package com.employees.employeeApp.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

    boolean success;
    String message;
    T data;

}
