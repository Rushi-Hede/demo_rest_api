package com.example.demo.service;

import com.example.demo.Exception.EmpNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.aspectj.bridge.MessageUtil.fail;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EmployeeServiceImplTest {


    @Mock
    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;
    AutoCloseable autoCloseable;
    Employee employee;
    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        employeeService= new EmployeeServiceImpl(employeeRepository);
        employee = new Employee(15,"Samuel jackson",
                98000,46,"Nashville");
    }
    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();

    }

    @Test
    void testCreateNewEmployee() {
        mock(Employee.class);
        mock(EmployeeRepository.class);

        when(employeeRepository.save(employee)).thenReturn(employee);
        assertThat(employeeService.createNewEmployee(employee)).isEqualTo("Employee created in the database");

    }

    @Test
    void testGetEmployeeByIdFound() {

        mock(Employee.class);
        mock(EmployeeRepository.class);

        // Case 1: If Found
        when(employeeRepository.findById(1l)).thenReturn(Optional.of(employee));
        Employee result= employeeService.getEmployeeById(1l);
        assertThat(result).isEqualTo(employee);


     }

     @Test
     void testGetEmployeeByIdNotFound(){

        mock(Employee.class);
        mock(EmployeeRepository.class);

         // Case 2: Employee not found
         when(employeeRepository.findById(2L)).thenReturn(Optional.empty());

         try {
             employeeService.getEmployeeById(2L);
             fail("Expected EmpNotFoundException, but no exception was thrown.");
         } catch (EmpNotFoundException exception) {
             assertThat(exception.getMessage()).isEqualTo("requested emp is not there");
         }


     }


    @Test
    void testGetAllEmployees() {
        mock(Employee.class);
        mock(EmployeeRepository.class);

        when(employeeRepository.findAll()).thenReturn(new ArrayList<Employee>(Collections.singleton(employee)));

        assertThat(employeeService.getAllEmployees().getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(employeeService.getAllEmployees().getBody()).containsExactly(employee);

    }

    @Test
    void testUpdateEmployeeById() {
        mock(Employee.class);
        mock(EmployeeRepository.class);
        when(employeeRepository.findById(1L)).thenReturn(Optional.ofNullable(employee));
        assertThat(employeeService.getEmployeeById(1).getEmp_name()).isEqualTo(employee.getEmp_name());   }

    @Test
    void testDeleteEmployeeById() {

    }

    @Test
    void deleteAllEmployees() {
    }
}