package com.mphasis.employee_payroll.service;

import java.util.List;

import com.mphasis.employee_payroll.model.AdminSalary;

public interface AdminSalaryService {
	AdminSalary saveAdminSalary(AdminSalary adminSalary);

	List<AdminSalary> getAllSalary();

	AdminSalary getSalaryById(long id);

	AdminSalary updateSalary(AdminSalary adminSalary, long id);

	void deleteSalary(long id);
}