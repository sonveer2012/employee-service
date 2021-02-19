package com.paypal.bfs.test.employeeserv.api;

import com.paypal.bfs.test.employeeserv.api.exception.EmployeeNotFoundException;

public interface EmployeeOperations<M, E> {
    public M findById(Integer id) throws EmployeeNotFoundException;

    public M create(M model);

    public void delete(Integer id) throws EmployeeNotFoundException;
}