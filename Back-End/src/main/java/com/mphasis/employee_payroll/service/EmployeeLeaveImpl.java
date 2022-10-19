package com.mphasis.employee_payroll.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mphasis.employee_payroll.exception.ResourceNotFoundException;
import com.mphasis.employee_payroll.model.EmployeeLeave;
import com.mphasis.employee_payroll.repository.EmployeeLeaveRepository;

@Service
public class EmployeeLeaveImpl implements EmployeeLeaveService {

	private EmployeeLeaveRepository employeeLeaveRepository;

	public EmployeeLeaveImpl(EmployeeLeaveRepository employeeLeaveRepository) {
		super();
		this.employeeLeaveRepository = employeeLeaveRepository;
	}

	@Override
	public List<EmployeeLeave> getAllLeave() {
		return employeeLeaveRepository.findAll();
	}

	@Override
	public EmployeeLeave getLeaveById(long id) {
		return employeeLeaveRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Leave", "Id", id));

	}

}