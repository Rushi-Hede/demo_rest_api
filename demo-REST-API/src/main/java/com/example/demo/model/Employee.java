package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;


@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long emp_id;

    @NotBlank(message = "Employee name cannot be blank")
    @Column(name = "emp_name")
    private String emp_name;

    @Positive(message = "Salary must be a positive value")
    @Column(name = "emp_salary")
    private float emp_salary;

    @Positive(message = "Age must be a positive value")
    @Column(name = "emp_age")
    private int emp_age;

    @NotBlank(message = "City cannot be blank")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "City should contain only alphabetical characters and spaces")
    @Column(name = "emp_city")
    private String emp_city;

    public long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(long emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public float getEmp_salary() {
        return emp_salary;
    }

    public void setEmp_salary(float emp_salary) {
        this.emp_salary = emp_salary;
    }

    public int getEmp_age() {
        return emp_age;
    }

    public void setEmp_age(int emp_age) {
        this.emp_age = emp_age;
    }

    public String getEmp_city() {
        return emp_city;
    }

    public void setEmp_city(String emp_city) {
        this.emp_city = emp_city;
    }

    public Employee(long emp_id, String emp_name, float emp_salary, int emp_age, String emp_city) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_salary = emp_salary;
        this.emp_age = emp_age;
        this.emp_city = emp_city;
    }

    public Employee() {

    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_salary=" + emp_salary +
                ", emp_age=" + emp_age +
                ", emp_city='" + emp_city + '\'' +
                '}';
    }
}
