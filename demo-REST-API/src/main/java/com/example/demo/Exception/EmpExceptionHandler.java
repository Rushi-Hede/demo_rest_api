package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmpExceptionHandler {

    @ExceptionHandler(value = {EmpNotFoundException.class})
    public ResponseEntity<Object>handleEmpNotFoundException(EmpNotFoundException empNotFoundException){

     EmpException empException = new EmpException(
             empNotFoundException.getMessage(),
             empNotFoundException.getCause(),
             HttpStatus.NOT_FOUND
      );
    return new ResponseEntity<>(empException,HttpStatus.NOT_FOUND);

    }
}
