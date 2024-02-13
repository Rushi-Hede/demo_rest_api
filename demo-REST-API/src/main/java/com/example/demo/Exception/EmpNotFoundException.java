package com.example.demo.Exception;

public class EmpNotFoundException extends RuntimeException{

    public EmpNotFoundException(String message) {
        super(message);
    }
}
