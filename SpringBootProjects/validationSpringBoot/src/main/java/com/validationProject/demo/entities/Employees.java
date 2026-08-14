package com.validationProject.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")
    @Size(min = 3,
            max = 50,
    message = "Name must contain between 3 and 50")
    private String name;

    @NotBlank(message = "email is required")
    @Email(message = "Please enter the valid email address")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(
            min = 8,
            max = 16,
            message = "Must be of 8 to 20 letters"
    )
    private String password;

    @NotBlank(message = "Phone is required")
    @Pattern(
            regexp = "^[0-9]{10}$"
    )
    private String phoneNumber;

    @Min(value = 18,
    message = "Age must be at least 18")
    @Max(value = 50,
            message = "Age should not be more than 50")

    private Integer age;

    @Positive(message = "Salary must be greater than 0")
    private Double salary;

    @NotBlank(message = "Department is required")
    private String department;

}
