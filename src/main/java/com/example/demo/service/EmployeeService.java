package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Employee;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(Long employeeId);

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Long employeeId, Employee employee);

    void deleteEmployee(Long employeeId);
}
