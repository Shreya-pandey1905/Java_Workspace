package com.employees.employeeApp.service;

import com.employees.employeeApp.dto.EmpResDto;
import com.employees.employeeApp.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    List<EmpResDto> getAllEmployees();
    EmpResDto createEmp(Employee employee);
    void updateEmp(Employee employee);
    void deleteEmp(Long id);
    EmpResDto getEmpById(Long id);

}
