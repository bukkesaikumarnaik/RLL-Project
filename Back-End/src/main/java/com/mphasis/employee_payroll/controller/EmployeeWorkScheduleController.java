package com.mphasis.employee_payroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mphasis.employee_payroll.model.EmployeeWorkSchedule;
import com.mphasis.employee_payroll.service.EmployeeWorkScheduleService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "false")
@RestController

@EnableWebMvc

@RequestMapping("/api/v1")
public class EmployeeWorkScheduleController {

	@Autowired
	EmployeeWorkScheduleService employeeWorkScheduleService;

	public EmployeeWorkScheduleController(EmployeeWorkScheduleService employeeWorkScheduleService) {
		super();
		this.employeeWorkScheduleService = employeeWorkScheduleService;
	}

	@GetMapping("/employeeworkschedules")
	public List<EmployeeWorkSchedule> getAllWork() {
		return employeeWorkScheduleService.getAllWork();
	}

	@GetMapping("/employeeworkschedules/{id}")
	public ResponseEntity<EmployeeWorkSchedule> getWorkById(@PathVariable("id") long empid) {
		return new ResponseEntity<EmployeeWorkSchedule>(employeeWorkScheduleService.getWorkById(empid), HttpStatus.OK);
	}
}