package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.ExcelService;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;
    private final ExcelService excelService;

    public EmployeeController(
            EmployeeService employeeService,
            ExcelService excelService) {

        this.employeeService = employeeService;
        this.excelService = excelService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {

        log.info("GET /api/employees called");

        List<Employee> employees = employeeService.getAllEmployees();

        log.info("Retrieved {} employees", employees.size());

        return employees;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(
            @PathVariable Long id) {

        log.info("GET /api/employees/{} called", id);

        Employee employee = employeeService.getEmployeeById(id)
                .orElseThrow(() -> {
                    log.error(
                            "Employee not found with id {}",
                            id);

                    return new RuntimeException(
                            "Employee not found with id: " + id);
                });

        log.info("Employee found with id {}", id);

        return employee;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(
            @RequestBody Employee employee) {

        log.info(
                "Creating employee {}",
                employee.getEmployeeId());

        Employee savedEmployee = employeeService.saveEmployee(employee);

        log.info("Employee created successfully");

        return savedEmployee;
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employee) {

        log.info("Updating employee {}", id);

        Employee updatedEmployee = employeeService.updateEmployee(
                id,
                employee);

        log.info(
                "Employee {} updated successfully",
                id);

        return updatedEmployee;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(
            @PathVariable Long id) {

        log.info("Deleting employee {}", id);

        employeeService.deleteEmployee(id);

        log.info(
                "Employee {} deleted successfully",
                id);
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportEmployees()
            throws Exception {

        log.info("Export employees request received");

        byte[] excelFile = excelService.exportEmployees();

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=employees.xlsx")
                .contentType(
                        MediaType.APPLICATION_OCTET_STREAM)
                .body(excelFile);
    }

    @PostMapping(value = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> importEmployees(
            @RequestParam("file") MultipartFile file)
            throws Exception {

        excelService.importEmployees(file);

        return ResponseEntity.ok(
                "Employees imported successfully");
    }
}