package com.web.demo.Exceptions;

public class EmployeeNotExistException extends RuntimeException {
    public EmployeeNotExistException(String message) {
        super(message);
    }
}
