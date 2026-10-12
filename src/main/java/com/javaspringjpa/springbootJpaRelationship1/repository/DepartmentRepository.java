package com.javaspringjpa.springbootJpaRelationship1.repository;

import com.javaspringjpa.springbootJpaRelationship1.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public DepartmentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Department save(Department department) {
        entityManager.persist(department);
        return department;
    }

    public Department getDepartmentById(Long departmentId) {
        Department department = entityManager.find(Department.class, departmentId);
        return department;
    }
}
