package com.example.projectmanagementapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projectmanagementapp.entity.Employee;
import com.example.projectmanagementapp.dao.EmployeeRepository;
import com.example.projectmanagementapp.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private final EmployeeService employeeService;

	@Autowired
	EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping
	public String displayEmployees(Model model) {
		List<Employee> employees = employeeService.getAll();
		model.addAttribute("employees", employees);
		return "employee/list-employees";

	}

	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employee/new-employee";
	}


	@PostMapping("/save")
	public String createEmployee(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees";
	}
}
