package com.example.projectmanagementapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.projectmanagementapp.entity.Employee;
import com.example.projectmanagementapp.entity.Project;
import com.example.projectmanagementapp.dao.EmployeeRepository;
import com.example.projectmanagementapp.dao.ProjectRepository;
import com.example.projectmanagementapp.service.EmployeeService;
import com.example.projectmanagementapp.service.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	private final ProjectService projectService;
	private final EmployeeService employeeService;

	@Autowired
	ProjectController(ProjectService projectService,
	                  EmployeeService employeeService) {
		this.projectService = projectService;
		this.employeeService = employeeService;
	}

	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = projectService.getAll();
		model.addAttribute("projects", projects);
		return "project/list-projects";
	}

	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project project = new Project();
		List<Employee> employees = employeeService.getAll();

		model.addAttribute("project", project);
		model.addAttribute("employees", employees);
		return "project/new-project";
	}

	@PostMapping("/save")
	public String createProject(Project project, @RequestParam List<Long> employees, Model model) {
		projectService.save(project);

		return "redirect:/projects";
	}
}
