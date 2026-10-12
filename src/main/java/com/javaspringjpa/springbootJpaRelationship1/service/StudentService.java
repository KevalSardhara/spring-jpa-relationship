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

//    @Transactional
//    public Student createStudent(Student student) {
//        Department department = new Department();
//        department.setName("DSA");
//        student.setDepartment(department);
//        departmentRepository.save(department);
//        return studentRepository.save(student);
//    }

    @Transactional
    public Student createStudent(Student student, Long departmentId) {
        Department department = departmentRepository.getDepartmentById(departmentId);
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
