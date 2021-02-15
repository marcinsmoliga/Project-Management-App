package com.example.projectmanagementapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectmanagementapp.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
