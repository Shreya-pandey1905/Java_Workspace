package com.example.demo.service;

import com.example.demo.DTO.ReqDto;
import com.example.demo.DTO.ResDto;
import com.example.demo.entities.Employees;
import com.example.demo.repository.EmployeesRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeesService {

    @Autowired
    EmployeesRepo employeesRepo;

    @Autowired
    ModelMapper modelMapper;

    public void saveEmployee(ReqDto reqDto){
        Employees employees = modelMapper.map(reqDto, Employees.class);
        employeesRepo.save(employees);
    }

    public  void saveAllEmployees(List<ReqDto> reqDto){
        List<Employees> employeesList = new ArrayList<>();
        for (ReqDto rd: reqDto){
            Employees employees = modelMapper.map(rd, Employees.class);
            Collections.addAll(employeesList, employees);
        }
                employeesRepo.saveAll(employeesList);

    }

    public List<ResDto> getAllEmployees() {
        List<Employees> employeesList =  employeesRepo.findAll();
        List<ResDto> dtoList = new ArrayList<>();

        for (Employees employees : employeesList) {
             ResDto resDto = modelMapper.map(employees,ResDto.class);
            dtoList.add(resDto);
          }
        return dtoList;
    }

    public ResDto get(int id){

       Employees employee = employeesRepo.findById(id).get();
       ResDto resDto =modelMapper.map(employee, ResDto.class);
       return resDto;
    }

    public void deleteById(int id){
       employeesRepo.deleteById(id);
    }



}
