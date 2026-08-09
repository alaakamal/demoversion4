package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.EMPLOYEES;

public interface EmployeeRepository extends JpaRepository<EMPLOYEES, Long> {

}
