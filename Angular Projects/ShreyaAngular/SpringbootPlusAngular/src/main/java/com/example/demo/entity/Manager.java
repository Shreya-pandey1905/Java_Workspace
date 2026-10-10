package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mid;
    private String mname;
    @OneToMany(     mappedBy = "manager",
            cascade = CascadeType.ALL,
            orphanRemoval = true)

    private List<Employee> employees;
}
