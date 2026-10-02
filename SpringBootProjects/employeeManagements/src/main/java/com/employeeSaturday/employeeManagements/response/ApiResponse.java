package com.employeeSaturday.employeeManagements.response;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

    private boolean success;
    private boolean error;
    private T data;
    private String message;

}