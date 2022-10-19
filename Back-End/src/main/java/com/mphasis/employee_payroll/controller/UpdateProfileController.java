package com.mphasis.employee_payroll.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mphasis.employee_payroll.model.UpdateProfile;
import com.mphasis.employee_payroll.service.UpdateProfileService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "false")
@RestController

@EnableWebMvc

@RequestMapping("/api/v1")
public class UpdateProfileController {

	private UpdateProfileService updateProfileService;

	public UpdateProfileController(UpdateProfileService updateProfileService) {
		super();
		this.updateProfileService = updateProfileService;
	}

	@PutMapping("/updateprofiles/{id}")
	public ResponseEntity<UpdateProfile> updateProfile(@PathVariable("id") long id,
			@RequestBody UpdateProfile updateProfile) {
		return new ResponseEntity<UpdateProfile>(updateProfileService.updateProfile(updateProfile, id), HttpStatus.OK);
	}
}