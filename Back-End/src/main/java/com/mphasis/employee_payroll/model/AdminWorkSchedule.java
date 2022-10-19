package com.mphasis.employee_payroll.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeeWork_schedule")
public class AdminWorkSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private long empid;

	@Column(name = "work_date")
	private String workdate;

	@Column(name = "work_time")
	private String worktime;

	@Column(name = "work_shift")
	private String workshift;

	@Column(name = "work_status")
	private String workstatus;

	public AdminWorkSchedule() {

	}

	public AdminWorkSchedule(long empid, String workdate, String worktime, String workshift, String workstatus) {
		super();
		this.empid = empid;
		this.workdate = workdate;
		this.workshift = workshift;
		this.workstatus = workstatus;
		this.worktime = worktime;
	}

	public long getempid() {
		return empid;
	}

	public void setempid(long empid) {
		this.empid = empid;
	}

	public String getworkdate() {
		return workdate;
	}

	public void setworkdate(String workdate) {
		this.workdate = workdate;
	}

	public String getworkshift() {
		return workshift;
	}

	public void setworkshift(String workshift) {
		this.workshift = workshift;
	}

	public String getworkstatus() {
		return workstatus;
	}

	public void setworkstatus(String workstatus) {
		this.workstatus = workstatus;
	}

	public String getworktime() {
		return worktime;
	}

	public void setworktime(String worktime) {
		this.worktime = worktime;
	}

}