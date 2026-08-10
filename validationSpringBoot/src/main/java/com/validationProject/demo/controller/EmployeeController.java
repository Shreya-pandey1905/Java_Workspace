package com.validationProject.demo.controller;

import com.validationProject.demo.entities.Employees;
import com.validationProject.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.Binding;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String showEmployeesForm(Model model){
        model.addAttribute("employees",new Employees());
        return "employeeForm";
    }

    @PostMapping("/employees/save")

    public String saveEmployees(@Valid  // restrictions from entity class via validations
                                @ModelAttribute Employees employees, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "employeeForm";
        }
        employeeService.save(employees);
        return "redirect:/employees";
    }

    @GetMapping("/employees")
    public String showEmployees(Model model){
        model.addAttribute("employees",employeeService.getAllEmployees());
        return "employees";
    }
}
