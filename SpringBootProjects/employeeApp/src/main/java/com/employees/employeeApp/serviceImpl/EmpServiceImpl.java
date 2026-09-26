package com.employees.employeeApp.serviceImpl;

import com.employees.employeeApp.dto.EmpResDto;
import com.employees.employeeApp.entity.Employee;
import com.employees.employeeApp.repo.empRepo;
import com.employees.employeeApp.service.EmployeeService;
import com.employees.employeeApp.util.MapperClass;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpServiceImpl implements EmployeeService {
    private final empRepo employeeRepo ;
    private final ModelMapper mapper;

    EmpServiceImpl(empRepo employeeRepo, ModelMapper mapper){
      this.employeeRepo = employeeRepo;
        this.mapper = mapper;


    }


    @Override
    public List<EmpResDto> getAllEmployees() {
        List<EmpResDto> list = new ArrayList<>();

        for (Employee employee : employeeRepo.findAll()) {
            EmpResDto dto = mapper.map(employee, EmpResDto.class);
            list.add(dto);
        }
        return list;
    }

    @Override
    public EmpResDto createEmp(Employee employee) {
       employee= employeeRepo.save(employee);
       EmpResDto dto = mapper.map(employee,EmpResDto.class);
         return dto;

    }

    @Override
    public void updateEmp(Employee employee) {



    }

    @Override
    public void deleteEmp(Long id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public EmpResDto getEmpById(Long id) {

       Employee employee = employeeRepo.findById(id)
               .orElseThrow();
       EmpResDto dto= mapper.map(employee,EmpResDto.class);
       return dto;
    }
}
