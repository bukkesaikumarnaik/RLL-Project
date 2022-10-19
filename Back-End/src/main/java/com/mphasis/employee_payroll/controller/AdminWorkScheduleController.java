package com.mphasis.employee_payroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.mphasis.employee_payroll.model.AdminWorkSchedule;
import com.mphasis.employee_payroll.service.AdminWorkScheduleService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "false")
@RestController

@EnableWebMvc

@RequestMapping("/api/v1")
public class AdminWorkScheduleController {

	@Autowired
	AdminWorkScheduleService adminWorkScheduleService;

	public AdminWorkScheduleController(AdminWorkScheduleService adminWorkScheduleService) {
		super();
		this.adminWorkScheduleService = adminWorkScheduleService;
	}
	@PostMapping("/schedules")
	public ResponseEntity<AdminWorkSchedule> saveAdminWorkSchedule(@RequestBody AdminWorkSchedule adminWorkSchedule) {
		return new ResponseEntity<AdminWorkSchedule>(adminWorkScheduleService.saveAdminWorkSchedule(adminWorkSchedule),
				HttpStatus.CREATED);
	}

	@GetMapping("/schedules")
	public List<AdminWorkSchedule> getAllWork() {
		return adminWorkScheduleService.getAllWork();
	}

	@GetMapping("/schedules/{id}")
	public ResponseEntity<AdminWorkSchedule> getWorkById(@PathVariable("id") long id) {
		return new ResponseEntity<AdminWorkSchedule>(adminWorkScheduleService.getWorkById(id), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(value = "/schedules/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminWorkSchedule> updateWorkSchedule(@PathVariable("id") long id,
			@RequestBody AdminWorkSchedule adminWorkSchedule) {
		return new ResponseEntity<AdminWorkSchedule>(adminWorkScheduleService.updateWorkSchedule(adminWorkSchedule, id),
				HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/schedules/{id}")
	public ResponseEntity<String> deleteWorkSchedule(@PathVariable("id") long id) {

		adminWorkScheduleService.deleteWork(id);

		return new ResponseEntity<String>("Work Schedule deleted successfully!.", HttpStatus.OK);
	}
}