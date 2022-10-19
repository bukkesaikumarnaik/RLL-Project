package com.mphasis.employee_payroll.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mphasis.employee_payroll.model.AdminSalary;
import com.mphasis.employee_payroll.service.AdminSalaryService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "false")
@RestController

@EnableWebMvc

@RequestMapping("/api/v1")
public class AdminSalaryController {

	private AdminSalaryService adminSalaryService;

	public AdminSalaryController(AdminSalaryService adminSalaryService) {
		super();
		this.adminSalaryService = adminSalaryService;
	}

	@PostMapping("/salarys")
	public ResponseEntity<AdminSalary> saveAdminSalary(@RequestBody AdminSalary adminSalary) {
		return new ResponseEntity<AdminSalary>(adminSalaryService.saveAdminSalary(adminSalary), HttpStatus.CREATED);
	}

	@GetMapping("/salarys")
	public List<AdminSalary> getAllSalary() {
		return adminSalaryService.getAllSalary();
	}

	@GetMapping("/salarys/{id}")
	public ResponseEntity<AdminSalary> getSalaryById(@PathVariable("id") long employeeId) {
		return new ResponseEntity<AdminSalary>(adminSalaryService.getSalaryById(employeeId), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(value = "/salarys/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminSalary> updateSalary(@PathVariable("id") long id, @RequestBody AdminSalary adminSalary) {
		return new ResponseEntity<AdminSalary>(adminSalaryService.updateSalary(adminSalary, id), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/salarys/{id}")
	public ResponseEntity<String> deleteSalary(@PathVariable("id") long id) {

		adminSalaryService.deleteSalary(id);

		return new ResponseEntity<String>("Salary deleted successfully!.", HttpStatus.OK);
	}

}