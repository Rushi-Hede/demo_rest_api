package com.example.demo.service;

import com.example.demo.Exception.EmpNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

   @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public String createNewEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Employee created in the database";
    }
    @Override
    public Employee getEmployeeById(long emp_id) {

        if( employeeRepository.findById(emp_id).isEmpty())
            throw new EmpNotFoundException("requested emp is not there");
        return employeeRepository.findById(emp_id).get();
    }


    @Override
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        employeeRepository.findAll().forEach(employeeList::add);
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }


    @Override
    public String updateEmployeeById(long emp_id, Employee employee) {
        Optional<Employee> emp = employeeRepository.findById(emp_id);
        if (emp.isPresent()) {
            Employee existEmp = emp.get();
            existEmp.setEmp_age(employee.getEmp_age());
            existEmp.setEmp_city(employee.getEmp_city());
            existEmp.setEmp_name(employee.getEmp_name());
            existEmp.setEmp_salary(employee.getEmp_salary());
            employeeRepository.save(existEmp);
            return " Employee details against Id " + emp_id + " updated";
        } else {
            return " Employee details do not exist for emp_id " + emp_id;
        }
    }

    @Override
    public String deleteEmployeeById(long emp_id) {
        employeeRepository.deleteById(emp_id);
        return " employee deleted successfully  ";
    }

    @Override
    public String deleteAllEmployees() {
        employeeRepository.deleteAll();
        return " All employees are deleted";
    }
}
