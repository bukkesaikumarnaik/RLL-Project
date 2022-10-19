package com.mphasis.employee_payroll.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mphasis.employee_payroll.exception.ResourceNotFoundException;
import com.mphasis.employee_payroll.model.AdminLeave;
import com.mphasis.employee_payroll.repository.AdminLeaveRepository;

@Service
public class AdminLeaveImpl implements AdminLeaveService {

	private AdminLeaveRepository adminLeaveRepository;

	public AdminLeaveImpl(AdminLeaveRepository adminLeaveRepository) {
		super();
		this.adminLeaveRepository = adminLeaveRepository;
	}

	@Override
	public AdminLeave saveAdminLeave(AdminLeave adminLeave) {
		return adminLeaveRepository.save(adminLeave);
	}

	@Override
	public List<AdminLeave> getAllLeave() {
		return adminLeaveRepository.findAll();
	}

	@Override
	public AdminLeave getLeaveById(long id) {
		return adminLeaveRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Leave", "Id", id));

	}

	@Override
	public AdminLeave updateLeave(AdminLeave adminLeave, long id) {

		AdminLeave adminLeaveDetails = adminLeaveRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Leave", "Id", id));

		adminLeaveDetails.setfrom_date(adminLeave.getfrom_date());
		adminLeaveDetails.setto_date(adminLeave.getto_date());
		adminLeaveDetails.setreason(adminLeave.getreason());
		adminLeaveDetails.setleave_type(adminLeave.getleave_type());
		adminLeaveDetails.setstatus(adminLeave.getstatus());

		adminLeaveRepository.save(adminLeaveDetails);
		return adminLeaveDetails;
	}

	@Override
	public void deleteLeave(long id) {

		adminLeaveRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Leave", "Id", id));
		adminLeaveRepository.deleteById(id);
	}

}