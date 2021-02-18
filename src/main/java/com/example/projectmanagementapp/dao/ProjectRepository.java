package com.example.projectmanagementapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectmanagementapp.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
