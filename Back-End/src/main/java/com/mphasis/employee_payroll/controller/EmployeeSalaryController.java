package com.mphasis.employee_payroll.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mphasis.employee_payroll.model.EmployeeSalary;
import com.mphasis.employee_payroll.service.EmployeeSalaryService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "false")
@RestController

@EnableWebMvc

@RequestMapping("/api/v1")
public class EmployeeSalaryController {

	private EmployeeSalaryService employeeSalaryService;

	public EmployeeSalaryController(EmployeeSalaryService employeeSalaryService) {
		super();
		this.employeeSalaryService = employeeSalaryService;
	}

	@GetMapping("/employeesalaries")
	public List<EmployeeSalary> getAllSalary() {
		return employeeSalaryService.getAllSalary();
	}

	@GetMapping("/employeesalaries/{id}")
	public ResponseEntity<EmployeeSalary> getSalaryById(@PathVariable("id") long employeeId) {
		return new ResponseEntity<EmployeeSalary>(employeeSalaryService.getSalaryById(employeeId), HttpStatus.OK);
	}

}