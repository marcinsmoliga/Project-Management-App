package com.example.projectmanagementapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.projectmanagementapp.entity.Employee;
import com.example.projectmanagementapp.entity.Project;
import com.example.projectmanagementapp.repository.EmployeeRepository;
import com.example.projectmanagementapp.repository.ProjectRepository;

@Controller
public class HomeController {
	private final ProjectRepository projectRepository;
	private final EmployeeRepository employeeRepository;

	@Autowired
	HomeController(ProjectRepository projectRepository,
	               EmployeeRepository employeeRepository) {
		this.projectRepository = projectRepository;
		this.employeeRepository = employeeRepository;
	}

	@GetMapping("/")
	public String displayHomePage(Model model) {
		List<Project> projects = projectRepository.findAll();
		List<Employee> employees = employeeRepository.findAll();
		model.addAttribute("projects", projects);
		model.addAttribute("employees", employees);
		return "main/home";
	}
}
