package com.developer.sumit.department_svc.repository;

import com.developer.sumit.department_svc.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
