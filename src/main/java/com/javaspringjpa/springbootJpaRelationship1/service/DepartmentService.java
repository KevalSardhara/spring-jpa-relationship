package com.javaspringjpa.springbootJpaRelationship1.service;

import com.javaspringjpa.springbootJpaRelationship1.model.Department;
import com.javaspringjpa.springbootJpaRelationship1.model.Student;
import com.javaspringjpa.springbootJpaRelationship1.repository.DepartmentRepository;
import com.javaspringjpa.springbootJpaRelationship1.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private StudentRepository studentRepository;

    public DepartmentService(DepartmentRepository departmentRepository, StudentRepository studentRepository) {
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Transactional
    public Department createDepartment(Department department, String studentName) {
        Department saveDepartment = departmentRepository.save(department);
        Student student = new Student();
        student.setName(studentName);
        student.setDepartment(department);

        // -----------------------------------------------------------------
        // This line is most important for the object pass through the null List and we make the self calling the object
        department.setStudents(new ArrayList<>());
        // -----------------------------------------------------------------

        System.out.println("Student: ----> " + department.getStudents());
        saveDepartment.getStudents().add(student);
        studentRepository.save(student);
        return saveDepartment;
    }
}
