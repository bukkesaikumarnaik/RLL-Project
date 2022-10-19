package com.mphasis.employee_payroll.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp_leave")
public class EmployeeLeave {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "emp_id")
	private long emp_id;

	@Column(name = "from_date")
	private Date from_date;

	@Column(name = "to_date")
	private Date to_date;

	@Column(name = "leave_type")
	private String leave_type;

	@Column(name = "reason")
	private String reason;

	@Column(name = "status")
	private String status;

	public EmployeeLeave(long emp_id, Date from_date, Date to_date, String leave_type, String reason, String status) {
		super();
		this.emp_id = emp_id;
		this.from_date = from_date;
		this.to_date = to_date;
		this.reason = reason;
		this.leave_type = leave_type;
		this.status = status;
	}

	public EmployeeLeave() {
	}

	public long getemp_id() {
		return emp_id;
	}

	public void setemp_id(long emp_id) {
		this.emp_id = emp_id;
	}

	public Date getfrom_date() {
		return from_date;
	}

	public void setfrom_date(Date from_date) {
		this.from_date = from_date;
	}

	public Date getto_date() {
		return to_date;
	}

	public void setto_date(Date to_date) {
		this.to_date = to_date;
	}

	public String getleave_type() {
		return leave_type;
	}

	public void setleave_type(String leave_type) {
		this.leave_type = leave_type;
	}

	public String getreason() {
		return reason;
	}

	public void setreason(String reason) {
		this.reason = reason;
	}

	public String getstatus() {
		return status;
	}

	public void setstatus(String status) {
		this.status = status;
	}

	public void setfrom_date(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setto_date(String string) {
		// TODO Auto-generated method stub
		
	}

}
