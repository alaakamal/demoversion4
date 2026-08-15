package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {

        log.info("GET /api/employees called");

        List<Employee> employees = employeeService.getAllEmployees();

        log.info("Retrieved {} employees", employees.size());

        return employees;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {

        log.info("GET /api/employees/{} called", id);

        Employee employee = employeeService.getEmployeeById(id)
                .orElseThrow(() -> {
                    log.error("Employee not found with id {}", id);
                    return new RuntimeException("Employee not found with id: " + id);
                });

        log.info("Employee found with id {}", id);

        return employee;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee) {

        log.info("Creating employee {}", employee.getEmployeeId());

        Employee savedEmployee = employeeService.saveEmployee(employee);

        log.info("Employee created successfully");

        return savedEmployee;
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employee) {

        log.info("Updating employee {}", id);

        Employee updatedEmployee = employeeService.updateEmployee(id, employee);

        log.info("Employee {} updated successfully", id);

        return updatedEmployee;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Long id) {

        log.info("Deleting employee {}", id);

        employeeService.deleteEmployee(id);

        log.info("Employee {} deleted successfully", id);
    }
}