package com.example.projectmanagementapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.projectmanagementapp.dto.ChartData;
import com.example.projectmanagementapp.dto.EmployeeProject;
import com.example.projectmanagementapp.entity.Employee;
import com.example.projectmanagementapp.entity.Project;
import com.example.projectmanagementapp.dao.EmployeeRepository;
import com.example.projectmanagementapp.dao.ProjectRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {
	private final ProjectRepository projectRepository;
	private final EmployeeRepository employeeRepository;

	@Value("${version}")
	private String version;

	@Autowired
	HomeController(ProjectRepository projectRepository,
	               EmployeeRepository employeeRepository) {
		this.projectRepository = projectRepository;
		this.employeeRepository = employeeRepository;
	}

	@GetMapping("/")
	public String displayHomePage(Model model) throws JsonProcessingException {
		model.addAttribute("version", version);

		List<Project> projects = projectRepository.findAll();
		model.addAttribute("projects", projects);

		List<ChartData> projectData = projectRepository.getProjectsStatus();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		model.addAttribute("projectStatusCount", jsonString);

		List<EmployeeProject> employeesProjectCount = employeeRepository.employeeProjects();
		model.addAttribute("employeesProjectCount", employeesProjectCount);
		return "main/home";
	}
}
