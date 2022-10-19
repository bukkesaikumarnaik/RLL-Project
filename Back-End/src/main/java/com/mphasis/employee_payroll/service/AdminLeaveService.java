package com.mphasis.employee_payroll.service;

import java.util.List;

import com.mphasis.employee_payroll.model.AdminLeave;

public interface AdminLeaveService {
	AdminLeave saveAdminLeave(AdminLeave adminLeave);

	List<AdminLeave> getAllLeave();

	AdminLeave getLeaveById(long id);

	AdminLeave updateLeave(AdminLeave adminLeave, long id);

	void deleteLeave(long id);
}