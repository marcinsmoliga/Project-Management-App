package com.example.projectmanagementapp.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectmanagementapp.entity.Employee;
import com.example.projectmanagementapp.entity.Project;
import com.example.projectmanagementapp.service.ProjectService;

@RestController
@RequestMapping("/app-api/projects")
public class ProjectApiController {

	private ProjectService projectService;

	@Autowired
	ProjectApiController(ProjectService projectService) {
		this.projectService = projectService;
	}

	@GetMapping()
	public List<Project> getProjects() {
		return projectService.getAll();
	}

	@GetMapping("/{id}")
	public Project getProjectById(@PathVariable("id") Long id) {
		return projectService.findById(id).get();
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Project create(@RequestBody Project project) {
		return projectService.save(project);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Project update(@RequestBody Project project) {
		return projectService.save(project);
	}

	@PatchMapping("/{id}")
	public Project partialUpdate(@PathVariable("id") Long id, @RequestBody @Valid Project patchProject) {
		Project project = projectService.findById(id).get();

		if (patchProject.getName() != null) {
			project.setName(patchProject.getName());
		}
		if (patchProject.getStage() != null) {
			project.setStage(patchProject.getStage());
		}
		if (patchProject.getDescription() != null) {
			project.setDescription(patchProject.getDescription());
		}

		return projectService.save(project);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		try {
			projectService.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}
}
