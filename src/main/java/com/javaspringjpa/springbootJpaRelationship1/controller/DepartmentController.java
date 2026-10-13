package com.javaspringjpa.springbootJpaRelationship1.controller;

import com.javaspringjpa.springbootJpaRelationship1.model.Department;
import com.javaspringjpa.springbootJpaRelationship1.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department saveDepartment = departmentService.createDepartment(department);
        return ResponseEntity.status(HttpStatus.OK).body(saveDepartment);
    }

    @PostMapping("/create/withStudent")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department,
                                                       @RequestParam String studentName) {

        Department saveDepartment = departmentService.createDepartment(department, studentName);
        return ResponseEntity.status(HttpStatus.OK).body(saveDepartment);
    }
}
