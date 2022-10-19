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

import com.mphasis.employee_payroll.model.AdminAttendance;
import com.mphasis.employee_payroll.service.AdminAttendanceService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "false")
@RestController

@EnableWebMvc

@RequestMapping("/api/v1")
public class AdminAttendanceController {

	private AdminAttendanceService adminAttendanceService;

	public AdminAttendanceController(AdminAttendanceService adminAttendanceService) {
		super();
		this.adminAttendanceService = adminAttendanceService;
	}

	@PostMapping("/attendances")
	public ResponseEntity<AdminAttendance> saveAdminAttendance(@RequestBody AdminAttendance adminAttendance) {
		return new ResponseEntity<AdminAttendance>(adminAttendanceService.saveAdminAttendance(adminAttendance),
				HttpStatus.CREATED);
	}

	@GetMapping("/attendances")
	public List<AdminAttendance> getAllAdmins() {
		return adminAttendanceService.findAllAttendance();
	}

	@GetMapping("/attendances/{id}")
	public ResponseEntity<AdminAttendance> getAttendanceById(@PathVariable("id") long employeeId) {
		return new ResponseEntity<AdminAttendance>(adminAttendanceService.getAttendanceById(employeeId), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(value = "/attendances/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminAttendance> updateAttendance(@PathVariable("id") long id,
			@RequestBody AdminAttendance adminAttendance) {
		return new ResponseEntity<AdminAttendance>(adminAttendanceService.updateAttendance(adminAttendance, id),
				HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/attendances/{id}")
	public ResponseEntity<String> deleteAttendance(@PathVariable("id") long id) {

		adminAttendanceService.deleteAttendance(id);

		return new ResponseEntity<String>("Attendance deleted successfully!.", HttpStatus.OK);
	}

}