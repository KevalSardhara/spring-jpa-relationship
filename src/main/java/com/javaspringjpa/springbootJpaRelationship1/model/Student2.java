package com.javaspringjpa.springbootJpaRelationship1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "student2_table")
public class Student2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "student2_course",
            joinColumns = @JoinColumn(name = "student2_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> course = new ArrayList<>();
}
