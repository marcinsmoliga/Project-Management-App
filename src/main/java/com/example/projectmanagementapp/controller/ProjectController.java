package com.example.projectmanagementapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projectmanagementapp.entity.Project;
import com.example.projectmanagementapp.repository.ProjectRepository;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	private final ProjectRepository projectRepository;

	@Autowired
	ProjectController(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project project = new Project();
		model.addAttribute("project", project);
		return "new_project";
	}

	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		projectRepository.save(project);
		return "redirect:/projects/new";
	}
}
