package com.example.projectmanagementapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.projectmanagementapp.dto.EmployeeProject;
import com.example.projectmanagementapp.entity.Employee;

@Repository
@RepositoryRestResource(collectionResourceRel = "apiemployees", path = "apiemployees")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(nativeQuery = true, value = "SELECT e.first_name AS firstName, e.last_name AS lastName, "
			+ "COUNT(pe.employee_id) AS projectCount FROM employee e LEFT JOIN project_employee pe "
			+ "ON pe.employee_id = e.employee_id GROUP BY e.first_name, e.last_name ORDER BY projectCount DESC")
	List<EmployeeProject> employeeProjects();

	Employee findByEmail(String s);

	Employee findByEmployeeId(long id);
}
