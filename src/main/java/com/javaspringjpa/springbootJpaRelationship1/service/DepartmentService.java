package com.javaspringjpa.springbootJpaRelationship1.service;

import com.javaspringjpa.springbootJpaRelationship1.model.Department;
import com.javaspringjpa.springbootJpaRelationship1.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
