package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeMapper;
import com.paypal.bfs.test.employeeserv.api.EmployeeOperations;
import com.paypal.bfs.test.employeeserv.api.entity.EmployeeInfo;
import com.paypal.bfs.test.employeeserv.api.exception.EmployeeNotFoundException;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.api.repository.EmployeeRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService implements EmployeeOperations<Employee, EmployeeInfo> {
    private final EmployeeRepository employeeRepository;

    @Override
    public Employee findById(Integer id) throws EmployeeNotFoundException {
        Optional<EmployeeInfo> entity = employeeRepository.findById(id);
        return entity.map(EmployeeMapper.model)
                     .orElseThrow(() -> new EmployeeNotFoundException("Record does not exist ", id,
                                                                      HttpStatus.NOT_FOUND));
    }

    @Override
    public Employee create(Employee model) {
        EmployeeInfo entity = EmployeeMapper.entity.apply(model);
        EmployeeInfo employeeInfoData =  employeeRepository.save(entity);
        return EmployeeMapper.model.apply(employeeInfoData);
    }

    @Override
    public void delete(Integer id) throws EmployeeNotFoundException {
        Optional<EmployeeInfo> entity = employeeRepository.findById(id);
        if (entity.isPresent()) {
            EmployeeInfo employeeInfo = entity.get();
            employeeRepository.delete(employeeInfo);
        }
        else {
            throw new EmployeeNotFoundException("Record does not exist ", id,
                                                HttpStatus.NOT_FOUND);
        }
    }

}