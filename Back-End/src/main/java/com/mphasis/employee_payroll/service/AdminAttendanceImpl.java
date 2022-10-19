package com.mphasis.employee_payroll.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mphasis.employee_payroll.exception.ResourceNotFoundException;
import com.mphasis.employee_payroll.model.AdminAttendance;
import com.mphasis.employee_payroll.repository.AdminAttendanceRepository;

@Service
public class AdminAttendanceImpl implements AdminAttendanceService {

	private AdminAttendanceRepository adminAttendanceRepository;

	public AdminAttendanceImpl(AdminAttendanceRepository adminAttendanceRepository) {
		super();
		this.adminAttendanceRepository = adminAttendanceRepository;
	}

	@Override
	public AdminAttendance saveAdminAttendance(AdminAttendance adminAttendance) {
		return adminAttendanceRepository.save(adminAttendance);
	}

	@Override
	public List<AdminAttendance> findAllAttendance() {
		return adminAttendanceRepository.findAll();
	}

	@Override
	public AdminAttendance getAttendanceById(long id) {
		return adminAttendanceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Attendance", "Id", id));

	}

	@Override
	public AdminAttendance updateAttendance(AdminAttendance adminAttendance, long id) {

		AdminAttendance adminAttendanceDetails = adminAttendanceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Attendance", "Id", id));

		adminAttendanceDetails.setEmp_name(adminAttendance.getEmp_name());
		adminAttendanceDetails.setEmail(adminAttendance.getEmail());
		adminAttendanceDetails.setDate(adminAttendance.getDate());
		adminAttendanceDetails.setStatus(adminAttendance.getStatus());

		adminAttendanceRepository.save(adminAttendanceDetails);
		return adminAttendanceDetails;
	}

	@Override
	public void deleteAttendance(long id) {

		adminAttendanceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Attendance", "Id", id));
		adminAttendanceRepository.deleteById(id);
	}

}