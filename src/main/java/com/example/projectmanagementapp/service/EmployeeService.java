package com.example.projectmanagementapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectmanagementapp.dao.EmployeeRepository;
import com.example.projectmanagementapp.dto.EmployeeProject;
import com.example.projectmanagementapp.entity.Employee;

@Service
public class EmployeeService {
	private final EmployeeRepository employeeRepository;

	@Autowired
	EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	public List<EmployeeProject> employeeProjects() {
		return employeeRepository.employeeProjects();
	}

	public Optional<Employee> findById(Long id) {
		return employeeRepository.findById(id);
	}
}
