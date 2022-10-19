package com.mphasis.employee_payroll.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mphasis.employee_payroll.exception.ResourceNotFoundException;
import com.mphasis.employee_payroll.model.EmployeeSalary;
import com.mphasis.employee_payroll.repository.EmployeeSalaryRepository;

@Service
public class EmployeeSalaryImpl implements EmployeeSalaryService {

	private EmployeeSalaryRepository employeeSalaryRepository;

	public EmployeeSalaryImpl(EmployeeSalaryRepository employeeSalaryRepository) {
		super();
		this.employeeSalaryRepository = employeeSalaryRepository;
	}

	@Override
	public List<EmployeeSalary> getAllSalary() {
		return employeeSalaryRepository.findAll();
	}

	@Override
	public EmployeeSalary getSalaryById(long id) {
		return employeeSalaryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Salary", "Id", id));

	}

}