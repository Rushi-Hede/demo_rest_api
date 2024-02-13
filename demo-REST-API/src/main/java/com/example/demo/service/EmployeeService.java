package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    String createNewEmployee(Employee employee);

    ResponseEntity<List<Employee>> getAllEmployees();

    Employee getEmployeeById(long emp_id);

    String updateEmployeeById(long emp_id, Employee employee);

    String deleteEmployeeById(long emp_id);

    String deleteAllEmployees();
}
