package com.example.projectmanagementapp;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.projectmanagementapp.entity.Employee;
import com.example.projectmanagementapp.entity.Project;
import com.example.projectmanagementapp.repository.EmployeeRepository;
import com.example.projectmanagementapp.repository.ProjectRepository;

@SpringBootApplication
public class ProjectManagementAppApplication {
//	private ProjectRepository projRepo;
//	private EmployeeRepository empRepo;
//
//	@Autowired
//	ProjectManagementAppApplication(ProjectRepository projRepo,
//	                                EmployeeRepository empRepo) {
//		this.projRepo = projRepo;
//		this.empRepo = empRepo;
//	}

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementAppApplication.class, args);
	}

}
