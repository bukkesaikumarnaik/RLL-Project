package com.mphasis.employee_payroll.service;

import java.util.List;

import com.mphasis.employee_payroll.model.EmployeeWorkSchedule;

public interface EmployeeWorkScheduleService {

	List<EmployeeWorkSchedule> getAllWork();

	EmployeeWorkSchedule getWorkById(long empid);
}