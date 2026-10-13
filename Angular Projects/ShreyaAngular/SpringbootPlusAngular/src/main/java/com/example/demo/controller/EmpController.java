package com.example.demo.controller;

import com.example.demo.dto.EmpDto;
import com.example.demo.dto.ManagerDto;
import com.example.demo.service.EmpService;
import com.example.demo.service.ManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Emp")
@CrossOrigin("http://localhost:4200/")
public class EmpController {

    private final EmpService empService;
    private final ManagerService managerService;

    EmpController(EmpService empService, ManagerService managerService) {
        this.empService = empService;
        this.managerService = managerService;
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<EmpDto>> fetchAllEmployees()
    {
        List<EmpDto> dto= empService.getAllEmployees();
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public EmpDto addEmployee(@RequestBody EmpDto empDto) {
        return empService.addEmployee(empDto);
    }

    @GetMapping("/getAllManagers")
    public ResponseEntity<List<ManagerDto>> fetchAllManagers(){
        List<ManagerDto> dto = managerService.getAllManagers();
        return ResponseEntity.ok().body(dto);
    }
}
