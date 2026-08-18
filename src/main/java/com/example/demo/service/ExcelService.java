package com.example.demo.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class ExcelService {

    private static final Logger log = LoggerFactory.getLogger(ExcelService.class);

    private final EmployeeRepository employeeRepository;

    public ExcelService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Export all employees to Excel file.
     */
    public byte[] exportEmployees() throws IOException {

        log.info("Starting employee export");

        List<Employee> employees = employeeRepository.findAll();

        try (Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            Sheet sheet = workbook.createSheet("Employees");

            Row header = sheet.createRow(0);

            header.createCell(0).setCellValue("Employee ID");
            header.createCell(1).setCellValue("First Name");
            header.createCell(2).setCellValue("Last Name");
            header.createCell(3).setCellValue("Email");
            header.createCell(4).setCellValue("Salary");
            header.createCell(5).setCellValue("HIRE_DATE");
            header.createCell(6).setCellValue("JOB_ID");

            int rowNum = 1;

            for (Employee employee : employees) {

                Row row = sheet.createRow(rowNum++);

                if (employee.getEmployeeId() != null) {
                    row.createCell(0)
                            .setCellValue(employee.getEmployeeId());
                }

                row.createCell(1)
                        .setCellValue(
                                employee.getFirstName() != null
                                        ? employee.getFirstName()
                                        : "");

                row.createCell(2)
                        .setCellValue(
                                employee.getLastName() != null
                                        ? employee.getLastName()
                                        : "");

                row.createCell(3)
                        .setCellValue(
                                employee.getEmail() != null
                                        ? employee.getEmail()
                                        : "");

                if (employee.getSalary() != null) {
                    row.createCell(4)
                            .setCellValue(
                                    employee.getSalary().doubleValue());
                }

                if (employee.getHireDate() != null) {
                    row.createCell(5)
                            .setCellValue(
                                    employee.getHireDate());
                }

                if (employee.getJobId() != null) {
                    row.createCell(6)
                            .setCellValue(employee.getJobId());
                }
            }

            for (int i = 0; i < 7; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(outputStream);

            log.info("Successfully exported {} employees",
                    employees.size());

            return outputStream.toByteArray();
        }
    }

    /**
     * Import employees from Excel file.
     */
    public void importEmployees(MultipartFile file)
            throws IOException {

        log.info("Starting employee import from file: {}",
                file.getOriginalFilename());

        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {

            Sheet sheet = workbook.getSheetAt(0);

            int importedCount = 0;

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);

                if (row == null) {
                    continue;
                }

                Employee employee = new Employee();

                if (row.getCell(0) != null) {
                    employee.setEmployeeId(
                            (long) row.getCell(0)
                                    .getNumericCellValue());
                }

                if (row.getCell(1) != null) {
                    employee.setFirstName(
                            row.getCell(1)
                                    .getStringCellValue());
                }

                if (row.getCell(2) != null) {
                    employee.setLastName(
                            row.getCell(2)
                                    .getStringCellValue());
                }

                if (row.getCell(3) != null) {
                    employee.setEmail(
                            row.getCell(3)
                                    .getStringCellValue());
                }

                if (row.getCell(4) != null) {
                    employee.setSalary(
                            BigDecimal.valueOf(
                                    row.getCell(4)
                                            .getNumericCellValue()));
                }
                if (row.getCell(5) != null) {
                    employee.setHireDate(
                            row.getCell(5)
                                    .getDateCellValue());
                }

                if (row.getCell(6) != null) {
                    employee.setJobId(
                            row.getCell(6)
                                    .getStringCellValue());
                }
                employeeRepository.save(employee);

                importedCount++;
            }

            log.info(
                    "Successfully imported {} employees",
                    importedCount);
        }
    }
}