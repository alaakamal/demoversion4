package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

@Entity
@Table(name = "EMPLOYEES", schema = "HR")
public class Employee {
    @Id
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public String getJobId() {
        return jobId;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public BigDecimal getCommissionPct() {
        return commissionPct;
    }

    public Long getManagerId() {
        return managerId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    @Column(name = "FIRST_NAME", length = 20)
    private String firstName;

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setCommissionPct(BigDecimal commissionPct) {
        this.commissionPct = commissionPct;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

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