package com.example.projectmanagementapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.projectmanagementapp.entity.Employee;
import com.example.projectmanagementapp.dao.EmployeeRepository;
import com.example.projectmanagementapp.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private final EmployeeService employeeService;

	@Autowired
	EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping
	public String displayEmployees(Model model) {
		List<Employee> employees = employeeService.getAll();
		model.addAttribute("employees", employees);
		return "employee/list-employees";

	}

	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employee/new-employee";
	}


	@PostMapping("/save")
	public String createEmployee(@Valid Employee employee, Errors errors) {
		if(errors.hasErrors()) {
			return "employee/new-employee";
		}
		employeeService.save(employee);
		return "redirect:/employees";
	}

	@GetMapping("/update")
	public String displayEmployeeUpdateForm(@RequestParam("id") long id, Model model) {
		Employee employee = employeeService.findByEmployeeId(id);
		model.addAttribute("employee", employee);
		return "employee/new-employee";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") long id, Model model) {
		Employee employee = employeeService.findByEmployeeId(id);
		employeeService.deleteEmployee(employee);
		return "redirect:/employees";
	}
}
