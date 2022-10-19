package com.mphasis.employee_payroll.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mphasis.employee_payroll.exception.ResourceNotFoundException;
import com.mphasis.employee_payroll.model.EmployeeWorkSchedule;
import com.mphasis.employee_payroll.repository.EmployeeWorkScheduleRepository;

@Service
public class EmployeeWorkScheduleImpl implements EmployeeWorkScheduleService {

	EmployeeWorkScheduleRepository employeeWorkScheduleRepository;

	public EmployeeWorkScheduleImpl(EmployeeWorkScheduleRepository employeeWorkScheduleRepository) {
		super();
		this.employeeWorkScheduleRepository = employeeWorkScheduleRepository;
	}

	@Override
	public List<EmployeeWorkSchedule> getAllWork() {
		return employeeWorkScheduleRepository.findAll();
	}

	@Override
	public EmployeeWorkSchedule getWorkById(long empid) {
		return employeeWorkScheduleRepository.findById(empid)
				.orElseThrow(() -> new ResourceNotFoundException("workschedule", "Id", empid));

	}
}
