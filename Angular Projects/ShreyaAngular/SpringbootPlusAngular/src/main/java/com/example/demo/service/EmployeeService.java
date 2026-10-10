package com.example.demo.service;

import com.example.demo.repo.EmpRepo;
import org.springframework.stereotype.Service;

@Service

public class EmployeeService {
    private final EmpRepo empRepo;

    EmployeeService(EmpRepo empRepo){
        this.empRepo= empRepo;
    }

}
