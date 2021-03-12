package com.example.projectmanagementapp.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.projectmanagementapp.entity.Employee;
import com.example.projectmanagementapp.service.EmployeeService;

public class UniqueValidator implements ConstraintValidator<UniqueValue, String> {

	private EmployeeService employeeService;

	@Autowired
	UniqueValidator(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Override
	public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
		Employee employee = employeeService.findByEmail(s);

		return employee == null;
	}
}
