package com.mphasis.employee_payroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mphasis.employee_payroll.model.User;
import com.mphasis.employee_payroll.service.AuthService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "false")
@RestController

@EnableWebMvc

public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/register")
	public User Register(@RequestBody User user) {
		return authService.register(user);

	}

	@PostMapping("/login")
	public User login(@RequestBody User user) {
		return authService.login(user);

	}
}