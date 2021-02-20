package com.example.dao;


import static org.junit.Assert.assertEquals;

import javax.swing.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.projectmanagementapp.ProjectManagementAppApplication;
import com.example.projectmanagementapp.dao.ProjectRepository;
import com.example.projectmanagementapp.entity.Project;

@ContextConfiguration(classes = ProjectManagementAppApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
@SqlGroup({@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:schema.sql", "classpath:data.sql"}),
		@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:drop.sql")})
public class ProjectRepositoryIntegrationTest {

	@Autowired
	ProjectRepository projectRepository;

	@Test
	public void ifNewProjectSaved_thenSuccess() {
		Project project = new Project("Test Project", "COMPLETED", "Test Description");
		projectRepository.save(project);

		assertEquals(5, projectRepository.findAll().size());
	}
}
