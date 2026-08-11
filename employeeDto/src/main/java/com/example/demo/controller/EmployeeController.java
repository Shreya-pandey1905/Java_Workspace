package com.example.demo.controller;

import com.example.demo.DTO.ReqDto;
import com.example.demo.DTO.ResDto;
import com.example.demo.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeesController")
public class EmployeeController {

    @Autowired
    EmployeesService employeesService;

    @PostMapping("/addAll")
    public void saveAllEmployees(@RequestBody List<ReqDto> employees){
            employeesService.saveAllEmployees(employees);
    }

    @PostMapping("/add")
    public void saveAllEmployees(@RequestBody ReqDto employees){
        employeesService.saveEmployee(employees);
    }

    @GetMapping("/getAll")
    public List<ResDto> getAllEmployees(){
        return employeesService.getAllEmployees();
    }

    @GetMapping("/getById/{id}")
    public ResDto getEmployees(@PathVariable int id){
        return employeesService.get(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id){
        employeesService.deleteById(id);
    }
}
