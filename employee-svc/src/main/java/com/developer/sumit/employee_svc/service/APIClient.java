package com.developer.sumit.employee_svc.service;

import com.developer.sumit.employee_svc.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SVC")
public interface APIClient {
    @GetMapping("/api/departments/{code}")
    DepartmentDto getDepartment(@PathVariable String code);

    }
