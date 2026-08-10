package com.validationProject.demo.repository;

import com.validationProject.demo.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employees,Integer> {
}
