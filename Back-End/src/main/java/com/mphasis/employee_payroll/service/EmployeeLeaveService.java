package com.mphasis.employee_payroll.service;

import java.util.List;

import com.mphasis.employee_payroll.model.EmployeeLeave;

public interface EmployeeLeaveService {

	List<EmployeeLeave> getAllLeave();

	EmployeeLeave getLeaveById(long id);

}