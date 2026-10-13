package com.javaspringjpa.springbootJpaRelationship1.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "student_relationship")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "department_id", nullable = false, referencedColumnName = "id")
    private Department department;
}
