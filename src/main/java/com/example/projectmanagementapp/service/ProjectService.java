package com.example.projectmanagementapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectmanagementapp.dao.ProjectRepository;
import com.example.projectmanagementapp.dto.ChartData;
import com.example.projectmanagementapp.entity.Project;

@Service
public class ProjectService {
	private final ProjectRepository projectRepository;

	@Autowired
	ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	public Project save(Project project) {
		return projectRepository.save(project);
	}

	public List<Project> getAll() {
		return projectRepository.findAll();
	}

	public List<ChartData> getProjectsStatus() {
		return projectRepository.getProjectsStatus();
	}


}
