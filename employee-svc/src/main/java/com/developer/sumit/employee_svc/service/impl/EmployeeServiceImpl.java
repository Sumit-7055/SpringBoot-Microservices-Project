package com.developer.sumit.employee_svc.service.impl;

import com.developer.sumit.employee_svc.dto.EmployeeDto;
import com.developer.sumit.employee_svc.entity.Employee;
import com.developer.sumit.employee_svc.repository.EmployeeRepository;
import com.developer.sumit.employee_svc.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto saveEmp(EmployeeDto employeeDto) {

        Employee Empl = new Employee(
                employeeDto.getId(),
                employeeDto.getEmail(),
                employeeDto.getFirstName(),
                employeeDto.getLastName()
        );

        Employee SavedEmpl = employeeRepository.save(Empl);

        EmployeeDto savedEmplDto = new EmployeeDto(
                SavedEmpl.getId(),
                employeeDto.getEmail(),
                employeeDto.getFirstName(),
                employeeDto.getLastName());

        return savedEmplDto;
    }
}
