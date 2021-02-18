package com.example.projectmanagementapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.projectmanagementapp.dto.EmployeeProject;
import com.example.projectmanagementapp.entity.Employee;
import com.example.projectmanagementapp.entity.Project;
import com.example.projectmanagementapp.dao.EmployeeRepository;
import com.example.projectmanagementapp.dao.ProjectRepository;

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
		List<EmployeeProject> employeesProjectCount = employeeRepository.employeeProjects();
		model.addAttribute("projects", projects);
		model.addAttribute("employeesProjectCount", employeesProjectCount);
		return "main/home";
	}
}
