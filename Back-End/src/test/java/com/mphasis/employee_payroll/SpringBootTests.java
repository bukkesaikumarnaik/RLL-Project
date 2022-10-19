package com.mphasis.employee_payroll;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mphasis.employee_payroll.model.AdminWorkSchedule;
import com.mphasis.employee_payroll.model.ChangePassword;
import com.mphasis.employee_payroll.model.UpdateProfile;
import com.mphasis.employee_payroll.model.User;
import com.mphasis.employee_payroll.repository.AdminWorkScheduleRepository;
import com.mphasis.employee_payroll.repository.ChangePasswordRepository;
import com.mphasis.employee_payroll.repository.UpdateProfileRepository;
import com.mphasis.employee_payroll.repository.UserRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class SpringBootTests {
	// ChangePassword....
	@Autowired
	ChangePasswordRepository cpr;

	@Test
	@Order(1)
	public void savepassword() {
		ChangePassword c = new ChangePassword();
		c.setEmp_id(1L);
		c.setOld_password("abc123");
		c.setNew_password("ravi");
		c.setConfirm_password("teja");
		cpr.save(c);
		assertNotNull(cpr.findById(2L).get());
	}

	@Test
	@Order(2)
	public void getAllPassword() {
		List<ChangePassword> list = cpr.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testUpdatePassword() {
		ChangePassword c = cpr.findById(1L).get();
		c.setNew_password("ravi");
		cpr.save(c);
		assertNotEquals("teja", cpr.findById(1L).get().getNew_password());
	}

	@Test
	@Order(4)
	public void testDeletePassword() {
		cpr.deleteById(2L);
		assertThat(cpr.existsById(2L)).isFalse();
	}

	// AdminWorkSchedule...
	@Autowired
	AdminWorkScheduleRepository ws;

	@Test
	@Order(5)
	public void savework() {
		AdminWorkSchedule a = new AdminWorkSchedule();
		a.setempid(4L);
		a.setworkdate("2022-02-22");
		a.setworkshift("dayshift");
		a.setworkstatus("working");
		a.setworktime("9am-6pm");
		ws.save(a);
		assertNotNull(ws.findById(4L).get());
	}

	@Test
	@Order(6)
	public void getAllwork() {
		List<AdminWorkSchedule> list = ws.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(7)
	public void testUpdatework() {
		AdminWorkSchedule c = ws.findById(4L).get();
		c.setworkstatus("working");
		ws.save(c);
		assertNotEquals("not", ws.findById(4L).get().getworkstatus());
	}

	@Test
	@Order(8)
	public void testDeletework() {
		ws.deleteById(6L);
		assertThat(ws.existsById(6L)).isFalse();
	}

	// UpdateProfile....
	@Autowired
	UpdateProfileRepository upr;

	@Test
	@Order(9)
	public void saveprofile() {
		UpdateProfile up = new UpdateProfile();
		up.setId(1L);
		up.setAge(22);
		up.setDate_of_joining("2020-02-20");
		up.setDesignation("tester");
		up.setEmail("abc@gmail.com");
		up.setEmp_name("ravi");
		up.setGender("m");
		up.setPassword("1234");
		upr.save(up);
		assertNotNull(upr.findById(1L).get());
	}

	@Test
	@Order(10)
	public void getAllProfile() {
		List<UpdateProfile> list = upr.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(11)
	public void testUpdateProfile() {
		UpdateProfile up = upr.findById(1L).get();
		up.setEmp_name("ravi");
		upr.save(up);
		assertNotEquals("teja", upr.findById(1L).get().getEmp_name());
	}

	@Test
	@Order(12)
	public void testDeleteProfile() {
		upr.deleteById(2L);
		assertThat(upr.existsById(2L)).isFalse();
	}

	// User.....
	@Autowired
	UserRepository ur;

	@Test
	@Order(13)
	public void saveuser() {
		User u = new User();
		u.setName("ravi");
		u.setPassword("1214");
		u.setRole("developer");
		u.setToken("");
		u.setUsername("abc@gmail.com");
		ur.save(u);
		assertNotNull(ur.findAll());
	}

	@Test
	@Order(14)
	public void getAllUser() {
		List<User> list = ur.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

}
