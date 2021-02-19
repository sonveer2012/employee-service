package com.paypal.bfs.test.employeeserv.api;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Interface for employee resource operations.
 */
public interface EmployeeResource {

    /**
     * Retrieves the {@link Employee} resource by id.
     *
     * @param id employee id.
     * @return {@link Employee} resource.
     */
    @RequestMapping("/v1/bfs/employees/{id}")
    ResponseEntity<Object> employeeGetById(@PathVariable("id") String id);


    @PostMapping("/v1/bfs/employee")
    ResponseEntity<Object> persistEmployee(@RequestBody Employee employee);


    @DeleteMapping("/v1/bfs/employees/{id}")
    ResponseEntity<Object> deleteEmployee(@PathVariable("id") String id);
}