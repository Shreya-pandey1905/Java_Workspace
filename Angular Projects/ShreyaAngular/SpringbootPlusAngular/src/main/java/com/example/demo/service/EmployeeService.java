package com.example.demo.service;

import com.example.demo.dto.EmpDto;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Manager;
import com.example.demo.repo.EmpRepo;
import com.example.demo.repo.ManagerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class EmployeeService implements EmpService {

    @Autowired
    private EmpRepo employeeRepository;
    @Autowired
    ModelMapper mapper;
    @Autowired
    ManagerRepo managerRepo;

      @Override
    public EmpDto addEmployee(EmpDto empDto) {

        Employee employee = mapper.map(empDto, Employee.class);

        Manager manager = managerRepo.findById(empDto.getManagerId())
                .orElseThrow(() -> new RuntimeException("Manager not found"));

        employee.setManager(manager);

        Employee savedEmployee = employeeRepository.save(employee);

        EmpDto dto = mapper.map(savedEmployee, EmpDto.class);

        dto.setMname(manager.getMname());

        return dto;
    }


    @Override
    public List<EmpDto> getAllEmployees() {
//        return employeeRepository.findAll()
//                .stream()
//                .map(e -> new EmpDto(
//                        e.getEid(),
//                        e.getName(),
//                        e.getSalary(),
//                        e.getManager() == null
//                                ? "not fetched"
//                                : e.getManager().getMname()
//                ))
//                .toList();

        return employeeRepository.findAll().stream().map(e -> {
            EmpDto empDto = mapper.map(e, EmpDto.class);
            empDto.setMname(e.getManager() == null ? "not fetched" : e.getManager().getMname());
            return empDto;
        }).toList();
    }
    @Override
    public EmpDto getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        EmpDto dto = mapper.map(employee, EmpDto.class);

        dto.setMname(employee.getManager() == null
                ? "not fetched"
                : employee.getManager().getMname());

        return dto;
    }

    @Override
    public EmpDto updateEmployee(Long id, EmpDto empDto) {

        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        existing.setName(empDto.getEname());
        existing.setSalary(empDto.getEsalary());

        Manager manager = managerRepo.findById(empDto.getManagerId())
                .orElseThrow(() -> new RuntimeException("Manager not found"));

        existing.setManager(manager);

        Employee updated = employeeRepository.save(existing);

        EmpDto dto = mapper.map(updated, EmpDto.class);
        dto.setMname(manager.getMname());

        return dto;
    }

    @Override
    public void deleteEmployee(Long id) {

    }
}
