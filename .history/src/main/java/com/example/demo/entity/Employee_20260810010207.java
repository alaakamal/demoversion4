package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Employee {
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

    public Object getFirstName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFirstName'");
    }

    public void setFirstName(Object firstName2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setFirstName'");
    }

    public Object getEmail() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmail'");
    }

    public void setEmail(Object email2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setEmail'");
    }

    public Object getPhoneNumber() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPhoneNumber'");
    }

    public Object getHireDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHireDate'");
    }

    public Object getJobId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getJobId'");
    }

    public Object getSalary() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSalary'");
    }

    public Object getCommissionPct() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCommissionPct'");
    }

    public Object getManagerId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getManagerId'");
    }

    public Object getDepartmentId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDepartmentId'");
    }

    public void setDepartmentId(Object departmentId2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDepartmentId'");
    }

    public void setManagerId(Object managerId2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setManagerId'");
    }

    public void setCommissionPct(Object commissionPct2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCommissionPct'");
    }

    public void setSalary(Object salary2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSalary'");
    }

    public void setJobId(Object jobId2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setJobId'");
    }

    public void setHireDate(Object hireDate2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setHireDate'");
    }

    public void setPhoneNumber(Object phoneNumber2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPhoneNumber'");
    }
}
