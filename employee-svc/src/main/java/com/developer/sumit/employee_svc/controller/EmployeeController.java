package com.developer.sumit.employee_svc.controller;

import com.developer.sumit.employee_svc.dto.APIResponseDto;
import com.developer.sumit.employee_svc.dto.EmployeeDto;
import com.developer.sumit.employee_svc.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {

        EmployeeDto savedEmployee = employeeService.saveEmp(employeeDto);
        return new ResponseEntity(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{Employee-id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("Employee-id") Long id){
        APIResponseDto apiResponseDto = employeeService.getEmployeeById(id);
        return new ResponseEntity(apiResponseDto, HttpStatus.OK);
    }
}
