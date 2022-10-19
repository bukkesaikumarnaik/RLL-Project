package com.mphasis.employee_payroll.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mphasis.employee_payroll.exception.ResourceNotFoundException;
import com.mphasis.employee_payroll.model.AdminWorkSchedule;
import com.mphasis.employee_payroll.repository.AdminWorkScheduleRepository;

@Service
public class AdminWorkScheduleImpl implements AdminWorkScheduleService {

	AdminWorkScheduleRepository adminWorkScheduleRepository;

	public AdminWorkScheduleImpl(AdminWorkScheduleRepository adminWorkScheduleRepository) {
		super();
		this.adminWorkScheduleRepository = adminWorkScheduleRepository;
	}

	@Override
	public AdminWorkSchedule saveAdminWorkSchedule(AdminWorkSchedule adminWorkSchedule) {
		return adminWorkScheduleRepository.save(adminWorkSchedule);
	}

	@Override
	public List<AdminWorkSchedule> getAllWork() {
		return adminWorkScheduleRepository.findAll();
	}

	@Override
	public AdminWorkSchedule getWorkById(long empid) {
		return adminWorkScheduleRepository.findById(empid)
				.orElseThrow(() -> new ResourceNotFoundException("workschedule", "Id", empid));

	}

	@Override
	public AdminWorkSchedule updateWorkSchedule(AdminWorkSchedule adminWorkSchedule, long empid) {

		AdminWorkSchedule adminWorkScheduleDetails = adminWorkScheduleRepository.findById(empid)
				.orElseThrow(() -> new ResourceNotFoundException("Workschedule", "Id", empid));

		adminWorkScheduleDetails.setempid(adminWorkSchedule.getempid());
		adminWorkScheduleDetails.setworkdate(adminWorkSchedule.getworkdate());
		adminWorkScheduleDetails.setworktime(adminWorkSchedule.getworktime());
		adminWorkScheduleDetails.setworkshift(adminWorkSchedule.getworkshift());
		adminWorkScheduleDetails.setworkstatus(adminWorkSchedule.getworkstatus());

		adminWorkScheduleRepository.save(adminWorkScheduleDetails);
		return adminWorkScheduleDetails;
	}

	@Override
	public void deleteWork(long empid) {

		adminWorkScheduleRepository.findById(empid)
				.orElseThrow(() -> new ResourceNotFoundException("workschedule", "Id", empid));
		adminWorkScheduleRepository.deleteById(empid);
	}

}