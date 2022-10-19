package com.mphasis.employee_payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mphasis.employee_payroll.model.AdminWorkSchedule;

@Repository
public interface AdminWorkScheduleRepository extends JpaRepository<AdminWorkSchedule, Long> {

}
