package com.example.demo.Exception;

import org.springframework.http.HttpStatus;

public class EmpException {


    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

    public EmpException(String message, Throwable throwable, HttpStatus httpStatus) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }
}
