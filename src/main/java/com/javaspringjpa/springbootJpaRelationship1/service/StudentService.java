package com.javaspringjpa.springbootJpaRelationship1.service;


import com.javaspringjpa.springbootJpaRelationship1.model.Department;
import com.javaspringjpa.springbootJpaRelationship1.model.Student;
import com.javaspringjpa.springbootJpaRelationship1.repository.DepartmentRepository;
import com.javaspringjpa.springbootJpaRelationship1.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private DepartmentRepository departmentRepository;


    public StudentService(StudentRepository studentRepository, DepartmentRepository departmentRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public Student createStudent(Student student, String deptName) {
//        Department department = new Department();
//        department.setName(deptName);

        Department addedDepartment = student.addDepartment(deptName);
        addedDepartment.getStudents().add(student);
        student.setDepartment(addedDepartment);
        departmentRepository.save(addedDepartment);
        return studentRepository.save(student);
    }

    @Transactional
    public Student createStudentWithExistingDepartment(Student student, Long departmentId) {
        Department department = departmentRepository.getDepartmentById(departmentId);
        department.getStudents().add(student);
        student.setDepartment(department);
        return studentRepository.save(student);
    }

    @Transactional
    public Student updateStudent(Student student, Long id) {
        Student existingStudent = getStudentById(id);
        if(existingStudent == null) {
            return null;
        }
        existingStudent.setName(student.getName());
        return existingStudent;
    }

    @Transactional
    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    @Transactional
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional
    public void removeStudent(Long id) {
        Student student = getStudentById(id);
        studentRepository.removeStudent(student);
    }
}
