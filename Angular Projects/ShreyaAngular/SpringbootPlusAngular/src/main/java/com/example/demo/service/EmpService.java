package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;

public interface EmpService {  Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
}
