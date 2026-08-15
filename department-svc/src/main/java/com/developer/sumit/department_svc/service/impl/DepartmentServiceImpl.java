package com.developer.sumit.department_svc.service.impl;

import com.developer.sumit.department_svc.dto.DepartmentDto;
import com.developer.sumit.department_svc.entity.Department;
import com.developer.sumit.department_svc.repository.DepartmentRepository;
import com.developer.sumit.department_svc.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department dept = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        Department savedDept = departmentRepository.save(dept);

        DepartmentDto savedDeptDto = new DepartmentDto(
                savedDept.getId(),
                savedDept.getDepartmentName(),
                savedDept.getDepartmentDescription(),
                savedDept.getDepartmentCode()
        );
        return savedDeptDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String deptcode) {
        Department getDept = departmentRepository.findByDepartmentCode(deptcode);

        DepartmentDto getDeptartment = new DepartmentDto(
                getDept.getId(),
                getDept.getDepartmentCode(),
                getDept.getDepartmentDescription(),
                getDept.getDepartmentName()
        );

        return getDeptartment;
    }
}
