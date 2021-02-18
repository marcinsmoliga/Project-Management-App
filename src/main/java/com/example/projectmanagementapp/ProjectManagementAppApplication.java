package com.example.projectmanagementapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
