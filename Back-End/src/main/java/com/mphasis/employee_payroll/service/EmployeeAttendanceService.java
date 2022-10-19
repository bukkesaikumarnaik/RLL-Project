package com.mphasis.employee_payroll.service;

import java.util.List;

import com.mphasis.employee_payroll.model.EmployeeAttendance;

public interface EmployeeAttendanceService {

	List<EmployeeAttendance> getAllAttendance();

	EmployeeAttendance getAttendanceById(long id);

}