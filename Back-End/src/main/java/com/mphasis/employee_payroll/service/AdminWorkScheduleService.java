
package com.mphasis.employee_payroll.service;

import java.util.List;

import com.mphasis.employee_payroll.model.AdminWorkSchedule;

public interface AdminWorkScheduleService {

	AdminWorkSchedule saveAdminWorkSchedule(AdminWorkSchedule adminWorkSchedule);

	List<AdminWorkSchedule> getAllWork();

	AdminWorkSchedule getWorkById(long empid);

	AdminWorkSchedule updateWorkSchedule(AdminWorkSchedule adminWorkSchedule, long empid);

	void deleteWork(long empid);

}
