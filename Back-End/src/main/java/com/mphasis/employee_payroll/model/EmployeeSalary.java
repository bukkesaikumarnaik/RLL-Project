package com.mphasis.employee_payroll.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_salary")
public class EmployeeSalary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private long emp_id;

	@Column(name = "emp_name")
	private String emp_name;

	@Column(name = "basic_pay")
	private String basic_pay;

	@Column(name = "deductions")
	private String deductions;

	@Column(name = "net_pay")
	private String net_pay;

	@Column(name = "month")
	private String month;

	public EmployeeSalary() {

	}

	public EmployeeSalary(long emp_id, String emp_name, String basic_pay, String deductions, String net_pay,
			String month) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.basic_pay = basic_pay;
		this.deductions = deductions;
		this.net_pay = net_pay;
		this.month = month;
	}

	public long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(long emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getBasic_pay() {
		return basic_pay;
	}

	public void setBasic_pay(String basic_pay) {
		this.basic_pay = basic_pay;
	}

	public String getDeductions() {
		return deductions;
	}

	public void setDeductions(String deductions) {
		this.deductions = deductions;
	}

	public String getNet_pay() {
		return net_pay;
	}

	public void setNet_pay(String net_pay) {
		this.net_pay = net_pay;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}
