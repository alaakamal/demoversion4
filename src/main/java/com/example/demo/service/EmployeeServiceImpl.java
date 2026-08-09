package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee employee) {

        Employee existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException(
                        "Employee not found with id: " + employeeId));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhoneNumber(employee.getPhoneNumber());
        existingEmployee.setHireDate(employee.getHireDate());
        existingEmployee.setJobId(employee.getJobId());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setCommissionPct(employee.getCommissionPct());
        existingEmployee.setManagerId(employee.getManagerId());
        existingEmployee.setDepartmentId(employee.getDepartmentId());

        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException(
                        "Employee not found with id: " + employeeId));

        employeeRepository.delete(employee);
    }
}
