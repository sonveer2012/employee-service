package com.paypal.bfs.test.employeeserv.api.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class EmployeeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer         id;
    private String          firstName;
    private String          lastName;
    private String          dateOfBirth;
    @OneToOne(targetEntity = EmployeeAddress.class,
              cascade = CascadeType.ALL)
    private EmployeeAddress employeeAddress;
}