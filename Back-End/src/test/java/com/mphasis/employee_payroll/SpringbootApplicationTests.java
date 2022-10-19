package com.mphasis.employee_payroll;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mphasis.employee_payroll.model.AdminAttendance;
import com.mphasis.employee_payroll.model.AdminLeave;
import com.mphasis.employee_payroll.model.AdminSalary;
import com.mphasis.employee_payroll.model.Employee;
import com.mphasis.employee_payroll.repository.AdminAttendanceRepository;
import com.mphasis.employee_payroll.repository.AdminLeaveRepository;
import com.mphasis.employee_payroll.repository.AdminSalaryRepository;
import com.mphasis.employee_payroll.repository.EmployeeRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class SpringbootApplicationTests {

	// AdminSalary......

	@Autowired
	AdminSalaryRepository repo;

	@Test
	@Order(1)
	public void testCreate() {
		AdminSalary a = new AdminSalary();
		a.setEmp_id(1);
		a.setEmp_name("Ravi");
		a.setBasic_pay("15000");
		a.setDeductions("40000");
		a.setNet_pay("12000");
		a.setMonth("feb");
		repo.save(a);
		assertNotNull(repo.findById(1L).get());

	}

	@Test
	@Order(2)
	public void getAllSalary() {
		List<AdminSalary> list = repo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testUpdate() {
		AdminSalary adm = repo.findById(1L).get();
		adm.setNet_pay("13000");
		repo.save(adm);
		assertNotEquals("12000", repo.findById(1L).get().getNet_pay());
	}

	@Test
	@Order(4)
	public void testDeleteSalary() {
		repo.deleteById(2L);
		assertThat(repo.existsById(2L)).isFalse();
	}

	// AdminLeave .....

	@Autowired
	AdminLeaveRepository adminLeaveRepository;

	@Test
	@Order(5)
	public void saveAdminLeave() {
		AdminLeave e = new AdminLeave();
		e.setemp_id(1);
		e.setfrom_date("2020-12-21 ");
		e.setto_date("2020-12-14");
		e.setleave_type("sick");
		e.setreason("fever");
		e.setstatus("rejected");
		adminLeaveRepository.save(e);
		assertNotNull(adminLeaveRepository.findById(1L).get());
	}

	@Test
	@Order(6)
	public void getAllLeave() {
		List<AdminLeave> list = adminLeaveRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(7)
	public void testUpdateLeave() {
		AdminLeave e = adminLeaveRepository.findById(1L).get();
		e.setleave_type("personal");
		adminLeaveRepository.save(e);
		assertNotEquals("health  ", adminLeaveRepository.findById(1L).get().getleave_type());
	}

	@Test
	@Order(8)
	public void testDeleteLeave() {
		adminLeaveRepository.deleteById(2L);
		assertThat(adminLeaveRepository.existsById(2L)).isFalse();
	}
	// AdminAttendance.....

	@Autowired
	AdminAttendanceRepository adminAttendanceRepository;

	@Test
	@Order(9)
	public void saveAdminAttendance() {
		AdminAttendance a = new AdminAttendance();
		a.setDate("2012-12-12");
		a.setEmail("abc@gmail.com");
		a.setEmp_id(15);
		a.setEmp_name("abc");
		a.setStatus("present");
		adminAttendanceRepository.save(a);
		assertNotNull(adminAttendanceRepository.findById(15L).get());
	}

	@Test
	@Order(10)
	public void getAllAttendance() {
		List<AdminAttendance> list = adminAttendanceRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(11)
	public void testUpdateAttendance() {
		AdminAttendance a = adminAttendanceRepository.findById(15L).get();
		a.setEmp_name("Ravi");
		adminAttendanceRepository.save(a);
		assertNotEquals("Teja", adminAttendanceRepository.findById(15L).get().getEmp_name());
	}

	@Test
	@Order(12)
	public void testDeleteAttendance() {
		adminAttendanceRepository.deleteById(6L);
		assertThat(adminAttendanceRepository.existsById(6L)).isFalse();
	}

	// AddEmployee....
	@Autowired
	EmployeeRepository er;

	@Test
	@Order(13)
	public void saveEmployee() {
		Employee e = new Employee();
		e.setId(1L);
		e.setAge(22);
		e.setDate_of_joining("2020-02-12");
		e.setDesignation("tester");
		e.setEmail("abc@gmail.com");
		e.setEmp_name("ravi");
		e.setGender("m");
		e.setPassword("123ed");
		er.save(e);
		assertNotNull(er.findById(1L).get());
	}

	@Test
	@Order(14)
	public void getAllEmployee() {
		List<Employee> list = er.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(15)
	public void testUpdateEmployee() {
		Employee e = er.findById(1L).get();
		e.setEmp_name("Ravi");
		er.save(e);
		assertNotEquals("Teja", er.findById(1L).get().getEmp_name());
	}

	@Test
	@Order(16)
	public void testDeleteEmployee() {
		er.deleteById(2L);
		assertThat(er.existsById(2L)).isFalse();
	}

}
