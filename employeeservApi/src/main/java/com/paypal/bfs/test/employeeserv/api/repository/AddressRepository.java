package com.paypal.bfs.test.employeeserv.api.repository;

import com.paypal.bfs.test.employeeserv.api.entity.EmployeeAddress;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<EmployeeAddress, Integer> {
}