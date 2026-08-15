package com.developer.sumit.employee_svc.service.impl;

import com.developer.sumit.employee_svc.dto.APIResponseDto;
import com.developer.sumit.employee_svc.dto.DepartmentDto;
import com.developer.sumit.employee_svc.dto.EmployeeDto;
import com.developer.sumit.employee_svc.entity.Employee;
import com.developer.sumit.employee_svc.mapper.EmployeeMapper;
import com.developer.sumit.employee_svc.repository.EmployeeRepository;
import com.developer.sumit.employee_svc.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

//    private RestTemplate restTemplate;
    private WebClient webClient;
    @Override
    public EmployeeDto saveEmp(EmployeeDto employeeDto) {

        Employee Empl = EmployeeMapper.mapToEmployee(employeeDto);

        Employee SavedEmpl = employeeRepository.save(Empl);

        EmployeeDto savedEmplDto = EmployeeMapper.mapToEmployeeDto(SavedEmpl);

        return savedEmplDto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(), DepartmentDto.class);

//        DepartmentDto departmentDTo = responseEntity.getBody();

        DepartmentDto departmentDTo = webClient.get().uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        EmployeeDto getEmplDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(getEmplDto);
        apiResponseDto.setDepartment(departmentDTo);
        return apiResponseDto;
    }
}
