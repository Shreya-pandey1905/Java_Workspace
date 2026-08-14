package com.validationProject.demo.service;

import com.validationProject.demo.entities.Employees;
import com.validationProject.demo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public void save(Employees employees){
         employeeRepo.save(employees);
    }

    public List<Employees> getAllEmployees(){
        return employeeRepo.findAll();
    }

}
