package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeOperations;
import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.entity.ApiInfo;
import com.paypal.bfs.test.employeeserv.api.entity.EmployeeInfo;
import com.paypal.bfs.test.employeeserv.api.exception.EmployeeNotFoundException;
import com.paypal.bfs.test.employeeserv.api.model.Employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

/**
 * Implementation class for employee resource.
 */
@AllArgsConstructor
@RestController
public class EmployeeResourceImpl implements EmployeeResource {
    private EmployeeOperations<Employee, EmployeeInfo> employeeOperations;

    @Override
    public ResponseEntity<Object> employeeGetById(String id) {
        try {
            return new ResponseEntity<>(employeeOperations.findById(Integer.valueOf(id)), HttpStatus.OK);
        }
        catch (EmployeeNotFoundException employeeNotFoundException) {
            return new ResponseEntity<>(new ApiInfo(employeeNotFoundException.getHttpStatus(),
                                                    employeeNotFoundException.getErrorMessage()),
                                        HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Object> persistEmployee(Employee employee) {
        return new ResponseEntity<>(employeeOperations.create(employee), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> deleteEmployee(String id) {
        try {
            employeeOperations.delete(Integer.valueOf(id));
            return new ResponseEntity<>(new ApiInfo(HttpStatus.OK, "Record has been deleted"), HttpStatus.OK);
        }
        catch (EmployeeNotFoundException employeeNotFoundException) {
            return new ResponseEntity<>(new ApiInfo(employeeNotFoundException.getHttpStatus(),
                                                    employeeNotFoundException.getErrorMessage()),
                                        HttpStatus.NOT_FOUND);
        }
    }
}