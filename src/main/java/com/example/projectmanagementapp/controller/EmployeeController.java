package com.example.projectmanagementapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projectmanagementapp.entity.Employee;
import com.example.projectmanagementapp.repository.EmployeeRepository;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private final EmployeeRepository employeeRepository;

	@Autowired
	EmployeeController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}

	@PostMapping("/save")
	public String createEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "redirect:/employees/new";
	}
}
