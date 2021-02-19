package com.paypal.bfs.test.employeeserv.api.entity;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiInfo {
    HttpStatus httpStatus;
    String     message;
}
