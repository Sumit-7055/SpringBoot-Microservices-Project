package com.developer.sumit.department_svc.service.impl;

import com.developer.sumit.department_svc.dto.DepartmentDto;
import com.developer.sumit.department_svc.entity.Department;
import com.developer.sumit.department_svc.mapper.DepartmentMapper;
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
        Department dept = DepartmentMapper.mapToDepartment(departmentDto);

        Department savedDept = departmentRepository.save(dept);

        DepartmentDto savedDeptDto = DepartmentMapper.mapToDepartmentDto(savedDept);

        return savedDeptDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String deptcode) {
        Department getDept = departmentRepository.findByDepartmentCode(deptcode);

        DepartmentDto getDeptartment = DepartmentMapper.mapToDepartmentDto(getDept);

        return getDeptartment;
    }
}
