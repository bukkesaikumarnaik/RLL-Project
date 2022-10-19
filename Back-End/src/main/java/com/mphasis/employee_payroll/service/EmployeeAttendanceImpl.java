package com.mphasis.employee_payroll.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mphasis.employee_payroll.exception.ResourceNotFoundException;
import com.mphasis.employee_payroll.model.EmployeeAttendance;
import com.mphasis.employee_payroll.repository.EmployeeAttendanceRepository;

@Service
public class EmployeeAttendanceImpl implements EmployeeAttendanceService {

	private EmployeeAttendanceRepository employeeAttendanceRepository;

	public EmployeeAttendanceImpl(EmployeeAttendanceRepository employeeAttendanceRepository) {
		super();
		this.employeeAttendanceRepository = employeeAttendanceRepository;
	}

	@Override
	public List<EmployeeAttendance> getAllAttendance() {
		return employeeAttendanceRepository.findAll();
	}

	@Override
	public EmployeeAttendance getAttendanceById(long id) {
		return employeeAttendanceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Leave", "Id", id));

	}
}