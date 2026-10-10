package com.example.demo.repo;

import com.example.demo.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<Manager,Long> {
}
