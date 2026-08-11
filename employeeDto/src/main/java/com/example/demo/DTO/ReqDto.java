package com.example.demo.DTO;

import lombok.Data;

@Data
public class ReqDto {

    private String name;
    private String username; // email
    private String password;
    private String gender;
    private String recoveryEmail;
    private String phone;
    private Integer age;
    private Double salary;

}
