package com.employees.employeeApp.repo;

import com.employees.employeeApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface empRepo extends JpaRepository<Employee,Long> {
}
