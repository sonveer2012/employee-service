package com.paypal.bfs.test.employeeserv.api;

import com.paypal.bfs.test.employeeserv.api.entity.EmployeeAddress;
import com.paypal.bfs.test.employeeserv.api.entity.EmployeeInfo;
import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;

import java.util.function.Function;

public interface EmployeeMapper {

    Function<EmployeeInfo, Employee> model = employeeInfo -> {
        Employee employee = new Employee();
        employee.setId(employeeInfo.getId());
        employee.setFirstName(employeeInfo.getFirstName());
        employee.setLastName(employeeInfo.getLastName());
        employee.setAddress(fetchAddress(employeeInfo.getEmployeeAddress()));
        employee.setDateOfBirth(employeeInfo.getDateOfBirth());
        return employee;
    };


    Function<Employee, EmployeeInfo> entity = employee -> {
        EmployeeInfo e = new EmployeeInfo();
        e.setFirstName(employee.getFirstName());
        e.setLastName(employee.getLastName());
        e.setDateOfBirth(employee.getDateOfBirth());
        e.setEmployeeAddress(fetchAddress(employee.getAddress()));
        return e;
    };


    static Address fetchAddress(EmployeeAddress employeeAddress) {
        Address address = new Address();
        address.setCity(employeeAddress.getCity());
        address.setCountry(employeeAddress.getCountry());
        address.setLine1(employeeAddress.getLine1());
        address.setLine2(employeeAddress.getLine2());
        address.setState(employeeAddress.getState());
        address.setZipcode(employeeAddress.getZipCode());
        return address;
    }


    static EmployeeAddress fetchAddress(Address address) {
        EmployeeAddress employeeAddress = new EmployeeAddress();
        employeeAddress.setCity(address.getCity());
        employeeAddress.setCountry(address.getCountry());
        employeeAddress.setLine1(address.getLine1());
        employeeAddress.setLine2(address.getLine2());
        employeeAddress.setState(address.getState());
        employeeAddress.setZipCode(address.getZipcode());
        return employeeAddress;
    }

}