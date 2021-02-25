package com.example.projectmanagementapp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectmanagementapp.entity.Employee;
import com.example.projectmanagementapp.service.EmployeeService;

@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {

	private final EmployeeService employeeService;

	@Autowired
	EmployeeApiController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping
	public List<Employee> getEmployees() {
		return employeeService.getAll();
	}
}
