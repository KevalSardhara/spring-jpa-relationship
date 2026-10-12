package com.javaspringjpa.springbootJpaRelationship1.repository;

import com.javaspringjpa.springbootJpaRelationship1.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Student save(Student student) {
        entityManager.persist(student);
        return student;
    }

    public Student getStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public List<Student> findAll() {
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    public void removeStudent(Student student) {
        entityManager.remove(student);
    }

}
