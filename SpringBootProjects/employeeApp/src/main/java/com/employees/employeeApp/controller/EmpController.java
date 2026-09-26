package com.employees.employeeApp.controller;

import com.employees.employeeApp.dto.ApiResponse;
import com.employees.employeeApp.dto.EmpResDto;
import com.employees.employeeApp.entity.Employee;
import com.employees.employeeApp.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmpController {

    private final EmployeeService employeeService;

    public EmpController(EmployeeService employeeService){
        this.employeeService= employeeService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<ApiResponse<List<EmpResDto>>> getAllEmployees(){
        List<EmpResDto> resDto = employeeService.getAllEmployees();
        if (resDto!=null){
            ApiResponse<List<EmpResDto>> response= new ApiResponse<>(
                    true,
                    "get successfully",
                    resDto
            );
            return ResponseEntity.ok(response);
        }
        else {
            ApiResponse<List<EmpResDto>> response= new ApiResponse<>(
                    true,
                    "something went wrong successfully",
                    null

            );
            return ResponseEntity.ok(response);
        }


    }


    @PostMapping("/createEmployee")
    public ResponseEntity<ApiResponse<EmpResDto>> createEmployee(@RequestBody Employee employee){

        EmpResDto empResDto= employeeService.createEmp(employee);
        if (empResDto!=null){

            ApiResponse<EmpResDto> response= new ApiResponse<>(
                    true,
                    "created successfully",
                    empResDto

            );
            return ResponseEntity.ok(response);
        }
        else {
            ApiResponse<EmpResDto> response= new ApiResponse<>(
                    true,
                    "Something went wrong successfully",
                    empResDto

            );
            return ResponseEntity.ok(response);
        }

    }
}
