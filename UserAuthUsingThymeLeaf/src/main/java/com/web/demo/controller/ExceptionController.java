package com.web.demo.controller;

import com.web.demo.Exceptions.EmployeeNotExistException;
import com.web.demo.Exceptions.GenericException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(EmployeeNotExistException.class)
    public String error(Exception exception){
        return "404";

    }

    @GetMapping("/generic")

    @ExceptionHandler(GenericException.class)
    public String exceptionss(Exception exception){
        return "404";

    }
}
