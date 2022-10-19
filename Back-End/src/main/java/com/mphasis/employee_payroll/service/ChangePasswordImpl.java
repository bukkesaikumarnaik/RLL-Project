package com.mphasis.employee_payroll.service;

import org.springframework.stereotype.Service;

import com.mphasis.employee_payroll.exception.ResourceNotFoundException;
import com.mphasis.employee_payroll.model.ChangePassword;
import com.mphasis.employee_payroll.repository.ChangePasswordRepository;

@Service
public class ChangePasswordImpl implements ChangePasswordService {

	private ChangePasswordRepository changePasswordRepository;

	public ChangePasswordImpl(ChangePasswordRepository changePasswordRepository) {
		super();
		this.changePasswordRepository = changePasswordRepository;
	}

	@Override
	public ChangePassword changePassword(ChangePassword changePassword, long id) {

		ChangePassword changePasswordDetails = changePasswordRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Password", "Id", id));

		changePasswordDetails.setOld_password(changePassword.getOld_password());
		changePasswordDetails.setNew_password(changePassword.getNew_password());
		changePasswordDetails.setConfirm_password(changePassword.getConfirm_password());

		changePasswordRepository.save(changePasswordDetails);
		return changePasswordDetails;
	}

}