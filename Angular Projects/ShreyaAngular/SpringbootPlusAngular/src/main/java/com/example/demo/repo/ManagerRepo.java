package com.example.demo.repo;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepo extends JpaRepository<Manager, Long> {
}


///dialect - for  ignoring the configurations