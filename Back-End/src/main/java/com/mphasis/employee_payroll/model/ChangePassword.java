package com.mphasis.employee_payroll.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "change_password")
public class ChangePassword {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private long emp_id;

	@Column(name = "old_password")
	private String old_password;

	@Column(name = "new_password")
	private String new_password;

	@Column(name = "confirm_password")
	private String confirm_password;

	public ChangePassword() {

	}

	public ChangePassword(long emp_id, String old_password, String new_password, String confirm_password) {
		super();
		this.emp_id = emp_id;
		this.old_password = old_password;
		this.new_password = new_password;
		this.confirm_password = confirm_password;
	}

	public long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(long emp_id) {
		this.emp_id = emp_id;
	}

	public String getOld_password() {
		return old_password;
	}

	public void setOld_password(String old_password) {
		this.old_password = old_password;
	}

	public String getNew_password() {
		return new_password;
	}

	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

}
