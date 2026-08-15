package com.developer.sumit.employee_svc.repository;

import com.developer.sumit.employee_svc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
