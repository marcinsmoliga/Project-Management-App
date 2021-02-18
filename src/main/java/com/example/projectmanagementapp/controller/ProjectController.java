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

@Controller
@RequestMapping("/projects")
public class ProjectController {
	private final ProjectRepository projectRepository;
	private final EmployeeRepository employeeRepository;

	@Autowired
	ProjectController(ProjectRepository projectRepository,
	                  EmployeeRepository employeeRepository) {
		this.projectRepository = projectRepository;
		this.employeeRepository = employeeRepository;
	}

	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = projectRepository.findAll();
		model.addAttribute("projects", projects);
		return "project/list-projects";
	}

	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project project = new Project();
		List<Employee> employees = employeeRepository.findAll();

		model.addAttribute("project", project);
		model.addAttribute("employees", employees);
		return "project/new-project";
	}

	@PostMapping("/save")
	public String createProject(Project project, @RequestParam List<Long> employees, Model model) {
		projectRepository.save(project);

		return "redirect:/projects";
	}
}
