package com.javaspringjpa.springbootJpaRelationship1.controller;

import com.javaspringjpa.springbootJpaRelationship1.model.Student;
import com.javaspringjpa.springbootJpaRelationship1.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student,
                                                 @RequestParam Long departmentId) {
        Student saveStudent = studentService.createStudent(student, departmentId);
        return ResponseEntity.status(HttpStatus.OK).body(saveStudent);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Long id) {
        Student saveStudent = studentService.updateStudent(student, id);
        return ResponseEntity.status(HttpStatus.OK).body(saveStudent);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Student student = studentService.getStudentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> studentList = studentService.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(studentList);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> removeStudent(@PathVariable Long id){
        studentService.removeStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body("remove Students");
    }
}

