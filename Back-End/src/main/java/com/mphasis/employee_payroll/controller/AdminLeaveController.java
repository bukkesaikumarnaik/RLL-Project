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

import com.mphasis.employee_payroll.model.AdminLeave;
import com.mphasis.employee_payroll.service.AdminLeaveService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "false")
@RestController

@EnableWebMvc

@RequestMapping("/api/v1")
public class AdminLeaveController {

	private AdminLeaveService adminLeaveService;

	public AdminLeaveController(AdminLeaveService adminLeaveService) {
		super();
		this.adminLeaveService = adminLeaveService;
	}

	@PostMapping("/leaves")
	public ResponseEntity<AdminLeave> saveAdminLeave(@RequestBody AdminLeave adminLeave) {
		return new ResponseEntity<AdminLeave>(adminLeaveService.saveAdminLeave(adminLeave), HttpStatus.CREATED);
	}

	@GetMapping("/leaves")
	public List<AdminLeave> getAllLeave() {
		return adminLeaveService.getAllLeave();
	}

	@GetMapping("/leaves/{id}")
	public ResponseEntity<AdminLeave> getLeaveById(@PathVariable("id") long employeeId) {
		return new ResponseEntity<AdminLeave>(adminLeaveService.getLeaveById(employeeId), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(value = "/leaves/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminLeave> updateLeave(@PathVariable("id") long id, @RequestBody AdminLeave adminLeave) {
		return new ResponseEntity<AdminLeave>(adminLeaveService.updateLeave(adminLeave, id), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/leaves/{id}")
	public ResponseEntity<String> deleteLeave(@PathVariable("id") long id) {

		adminLeaveService.deleteLeave(id);

		return new ResponseEntity<String>("Leave deleted successfully!.", HttpStatus.OK);
	}

}