package com.mphasis.employee_payroll.service;

import org.springframework.stereotype.Service;

import com.mphasis.employee_payroll.exception.ResourceNotFoundException;
import com.mphasis.employee_payroll.model.UpdateProfile;
import com.mphasis.employee_payroll.repository.UpdateProfileRepository;

@Service
public class UpdateProfileImpl implements UpdateProfileService {

	private UpdateProfileRepository updateProfileRepository;

	public UpdateProfileImpl(UpdateProfileRepository updateProfileRepository) {
		super();
		this.updateProfileRepository = updateProfileRepository;
	}

	@Override
	public UpdateProfile updateProfile(UpdateProfile updateProfile, long id) {

		UpdateProfile updateProfileDetails = updateProfileRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Profile", "Id", id));

		updateProfileDetails.setEmp_name(updateProfile.getEmp_name());
		updateProfileDetails.setDate_of_joining(updateProfile.getDate_of_joining());
		updateProfileDetails.setGender(updateProfile.getGender());
		updateProfileDetails.setAge(updateProfile.getAge());
		updateProfileDetails.setDesignation(updateProfile.getDesignation());
		updateProfileDetails.setEmail(updateProfile.getEmail());
		updateProfileDetails.setPassword(updateProfile.getPassword());

		updateProfileRepository.save(updateProfileDetails);
		return updateProfileDetails;
	}

}