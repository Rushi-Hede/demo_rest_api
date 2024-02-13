package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public String createNewEmployee(@Valid @RequestBody Employee employee) {
        logger.info("Received request to create a new employee: {}", employee);
        String result = employeeService.createNewEmployee(employee);
        logger.info("creating a new employee: {}", result);
        return result;
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        logger.info("Received request to retrieve all employees.");
        ResponseEntity<List<Employee>> responseEntity = employeeService.getAllEmployees();
        logger.info("Returning all employees: {}", responseEntity.getBody());
        return responseEntity;
    }

    @GetMapping("/employee/{emp_id}")
    public Employee getEmployeeById(@PathVariable long emp_id) {
        logger.info("Received request to retrieve employee by ID: {}", emp_id);
        Employee employee = employeeService.getEmployeeById(emp_id);
        logger.info("Returning employee: {}", employee);
        return employee;
    }

    @PutMapping("/employee/{emp_id}")
    public String updateEmployeeById(@PathVariable long emp_id, @RequestBody Employee employee) {
        logger.info("Received request to update employee by ID: {}, new details: {}", emp_id, employee);
        String result = employeeService.updateEmployeeById(emp_id, employee);
        logger.info("updating employee: {}", result);
        return result;
    }

    @DeleteMapping("/employee/{emp_id}")
    public String deleteEmployeeById(@PathVariable long emp_id) {
        logger.info("Received request to delete employee by ID: {}", emp_id);
        String result = employeeService.deleteEmployeeById(emp_id);
        logger.info("Result of deleting employee: {}", result);
        return result;
    }

    @DeleteMapping("/employee")
    public String deleteAllEmployees() {
        logger.info("Received request to delete all employees.");
        String result = employeeService.deleteAllEmployees();
        logger.info("Result of deleting all employees: {}", result);
        return result;
    }
}
