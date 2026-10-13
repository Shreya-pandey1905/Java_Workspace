package com.example.demo.service;

import com.example.demo.dto.EmpDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmpService {

    EmpDto addEmployee(EmpDto empDto);

    List<EmpDto> getAllEmployees();

    EmpDto getEmployeeById(Long id);

    EmpDto updateEmployee(Long id, EmpDto empDto);

    void deleteEmployee(Long id);
}