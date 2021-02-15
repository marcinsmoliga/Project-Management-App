package com.example.projectmanagementapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projectmanagementapp.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
}
