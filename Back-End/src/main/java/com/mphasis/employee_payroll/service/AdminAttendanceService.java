package com.mphasis.employee_payroll.service;

import java.util.List;

import com.mphasis.employee_payroll.model.AdminAttendance;

public interface AdminAttendanceService {
	AdminAttendance saveAdminAttendance(AdminAttendance adminAttendance);

	List<AdminAttendance> findAllAttendance();

	AdminAttendance getAttendanceById(long id);

	AdminAttendance updateAttendance(AdminAttendance adminAttendance, long id);

	void deleteAttendance(long id);
}