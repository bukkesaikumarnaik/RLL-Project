package com.mphasis.employee_payroll.service;

import java.util.List;

import com.mphasis.employee_payroll.model.EmployeeSalary;

public interface EmployeeSalaryService {

	List<EmployeeSalary> getAllSalary();

	EmployeeSalary getSalaryById(long id);

}