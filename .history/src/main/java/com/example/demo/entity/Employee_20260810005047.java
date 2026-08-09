package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class EMPLOYEES {
    @Id
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;

    @Column(name = "FIRST_NAME", length = 20)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 25)
    private String lastName;

    @Column(name = "EMAIL", nullable = false, length = 25)
    private String email;

    @Column(name = "PHONE_NUMBER", length = 20)
    private String phoneNumber;

    @Column(name = "HIRE_DATE", nullable = false)
    private LocalDate hireDate;

    @Column(name = "JOB_ID", nullable = false, length = 10)
    private String jobId;

    @Column(name = "SALARY", precision = 8, scale = 2)
    private BigDecimal salary;

    @Column(name = "COMMISSION_PCT", precision = 2, scale = 2)
    private BigDecimal commissionPct;

    @Column(name = "MANAGER_ID")
    private Long managerId;

    @Column(name = "DEPARTMENT_ID")
    private Integer departmentId;
}
