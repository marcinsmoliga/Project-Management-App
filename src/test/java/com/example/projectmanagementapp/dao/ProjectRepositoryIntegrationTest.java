package com.example.projectmanagementapp.dao;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.projectmanagementapp.entity.Project;

@SpringBootTest
@RunWith(SpringRunner.class)
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
