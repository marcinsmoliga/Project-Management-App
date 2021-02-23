package com.example.projectmanagementapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.projectmanagementapp.dto.ChartData;
import com.example.projectmanagementapp.dto.EmployeeProject;
import com.example.projectmanagementapp.entity.Project;
import com.example.projectmanagementapp.dao.EmployeeRepository;
import com.example.projectmanagementapp.dao.ProjectRepository;
import com.example.projectmanagementapp.service.EmployeeService;
import com.example.projectmanagementapp.service.ProjectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {
	private final ProjectService projectService;
	private final EmployeeService employeeService;

	@Value("${version}")
	private String version;

	@Autowired
	HomeController(ProjectService projectService, EmployeeService employeeService) {
		this.projectService = projectService;
		this.employeeService = employeeService;
	}

	@GetMapping("/")
	public String displayHomePage(Model model) throws JsonProcessingException {
		model.addAttribute("version", version);

		List<Project> projects = projectService.getAll();
		model.addAttribute("projects", projects);

		List<ChartData> projectData = projectService.getProjectsStatus();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		model.addAttribute("projectStatusCount", jsonString);

		List<EmployeeProject> employeesProjectCount = employeeService.employeeProjects();
		model.addAttribute("employeesProjectCount", employeesProjectCount);
		return "main/home";
	}
}
