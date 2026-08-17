package com.developer.sumit.employee_svc.service.impl;

import com.developer.sumit.employee_svc.dto.APIResponseDto;
import com.developer.sumit.employee_svc.dto.DepartmentDto;
import com.developer.sumit.employee_svc.dto.EmployeeDto;
import com.developer.sumit.employee_svc.entity.Employee;
import com.developer.sumit.employee_svc.mapper.EmployeeMapper;
import com.developer.sumit.employee_svc.repository.EmployeeRepository;
import com.developer.sumit.employee_svc.service.APIClient;
import com.developer.sumit.employee_svc.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepository employeeRepository;

//    private RestTemplate restTemplate;
    private WebClient webClient;
    private APIClient apiclient;
    //APIClient is nothing but fignclient

    @Override
    public EmployeeDto saveEmp(EmployeeDto employeeDto) {

        Employee Empl = EmployeeMapper.mapToEmployee(employeeDto);

        Employee SavedEmpl = employeeRepository.save(Empl);

        EmployeeDto savedEmplDto = EmployeeMapper.mapToEmployeeDto(SavedEmpl);

        return savedEmplDto;
    }

    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getdefaultDepartment" )
    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        LOGGER.info("inside getEmployeeById() method");

        Employee employee = employeeRepository.findById(employeeId).get();

//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(), DepartmentDto.class);

//        DepartmentDto departmentDTo = responseEntity.getBody();

        DepartmentDto departmentDTo = webClient.get().uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

//        DepartmentDto departmentDTo = apiclient.getDepartment(employee.getDepartmentCode());


        EmployeeDto getEmplDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(getEmplDto);
        apiResponseDto.setDepartment(departmentDTo);
        return apiResponseDto;
    }

    public APIResponseDto getdefaultDepartment(long employeeId,Exception exception){
        LOGGER.info("inside getDefaultDepartment() method");

        Employee employee = employeeRepository.findById(employeeId).get();
        DepartmentDto departmentDTo = new DepartmentDto();
        departmentDTo.setDepartmentName("R&D Department");
        departmentDTo.setDepartmentCode("RD001");
        departmentDTo.setDepartmentDescription("Research and dev depart");

            EmployeeDto getEmplDto = EmployeeMapper.mapToEmployeeDto(employee);

            APIResponseDto apiResponseDto = new APIResponseDto();
            apiResponseDto.setEmployee(getEmplDto);
            apiResponseDto.setDepartment(departmentDTo);
            return apiResponseDto;

    }


}
