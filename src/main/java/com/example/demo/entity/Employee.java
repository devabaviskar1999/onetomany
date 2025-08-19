package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @ManyToOne()
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

}
