package com.example.projectmanagementapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectmanagementapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
