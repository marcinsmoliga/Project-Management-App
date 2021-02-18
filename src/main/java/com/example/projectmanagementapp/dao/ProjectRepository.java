package com.example.projectmanagementapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.projectmanagementapp.dto.ChartData;
import com.example.projectmanagementapp.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	@Query(nativeQuery = true, value = "SELECT stage AS label, COUNT(*) AS value "
			+ "FROM project GROUP BY stage")
	List<ChartData> getProjectsStatus();
}
