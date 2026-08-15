package com.developer.sumit.employee_svc.service.impl;

import com.developer.sumit.employee_svc.dto.EmployeeDto;
import com.developer.sumit.employee_svc.entity.Employee;
import com.developer.sumit.employee_svc.repository.EmployeeRepository;
import com.developer.sumit.employee_svc.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
                SavedEmpl.getEmail(),
                SavedEmpl.getFirstName(),
                SavedEmpl.getLastName());

        return savedEmplDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        EmployeeDto getEmplDto = new EmployeeDto(
                employee.getId(),
                employee.getEmail(),
                employee.getFirstName(),
                employee.getLastName());

        return getEmplDto;
    }
}
