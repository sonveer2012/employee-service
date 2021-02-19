package com.paypal.bfs.test.employeeserv.api.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class EmployeeNotFoundException extends Exception {
    HttpStatus httpStatus;
    String     errorMessage;
    Integer    id;

    public EmployeeNotFoundException(String errorMessage, Integer id, HttpStatus httpStatus) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
        this.id = id;
    }
}