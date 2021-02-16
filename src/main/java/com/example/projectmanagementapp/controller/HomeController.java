package com.example.projectmanagementapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.projectmanagementapp.entity.Project;
import com.example.projectmanagementapp.repository.ProjectRepository;

@Controller
public class HomeController {
	private final ProjectRepository projectRepository;

	@Autowired
	HomeController(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	@GetMapping("/")
	public String displayHomePage(Model model) {
		List<Project> projects = projectRepository.findAll();
		model.addAttribute("projects", projects);
		return "hoome";
	}
}
