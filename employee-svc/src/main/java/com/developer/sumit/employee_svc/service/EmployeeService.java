package com.developer.sumit.employee_svc.service;

import com.developer.sumit.employee_svc.dto.APIResponseDto;
import com.developer.sumit.employee_svc.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmp(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
