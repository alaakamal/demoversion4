package com.example.demo.service;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(Long employeeId);

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Long employeeId, Employee employee);

    void deleteEmployee(Long employeeId);
}
