package com.developer.sumit.employee_svc.repository;

import com.developer.sumit.employee_svc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
