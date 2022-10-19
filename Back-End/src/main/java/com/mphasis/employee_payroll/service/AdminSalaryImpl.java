package com.mphasis.employee_payroll.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mphasis.employee_payroll.exception.ResourceNotFoundException;
import com.mphasis.employee_payroll.model.AdminSalary;
import com.mphasis.employee_payroll.repository.AdminSalaryRepository;

@Service
public class AdminSalaryImpl implements AdminSalaryService {

	private AdminSalaryRepository adminSalaryRepository;

	public AdminSalaryImpl(AdminSalaryRepository adminSalaryRepository) {
		super();
		this.adminSalaryRepository = adminSalaryRepository;
	}

	@Override
	public AdminSalary saveAdminSalary(AdminSalary adminSalary) {
		return adminSalaryRepository.save(adminSalary);
	}

	@Override
	public List<AdminSalary> getAllSalary() {
		return adminSalaryRepository.findAll();
	}

	@Override
	public AdminSalary getSalaryById(long id) {
		return adminSalaryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Salary", "Id", id));

	}

	@Override
	public AdminSalary updateSalary(AdminSalary adminSalary, long id) {

		AdminSalary adminSalaryDetails = adminSalaryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Salary", "Id", id));

		adminSalaryDetails.setEmp_name(adminSalary.getEmp_name());
		adminSalaryDetails.setBasic_pay(adminSalary.getBasic_pay());
		adminSalaryDetails.setDeductions(adminSalary.getDeductions());
		adminSalaryDetails.setNet_pay(adminSalary.getNet_pay());
		adminSalaryDetails.setMonth(adminSalary.getMonth());

		adminSalaryRepository.save(adminSalaryDetails);
		return adminSalaryDetails;
	}

	@Override
	public void deleteSalary(long id) {

		adminSalaryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Salary", "Id", id));
		adminSalaryRepository.deleteById(id);
	}

}