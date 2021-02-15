package com.example.projectmanagementapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projectmanagementapp.entity.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {


	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project project = new Project();
		model.addAttribute("project", project);
		return "new_project";
	}
}
