package com.userAuthentication.UserAuthentication.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class UserAuthRequestDto {

    @NotBlank(message = "Username is required")
    @Size(message = "between 5 to 50", max = 5,min = 50)
    private String username;

    @Size(min = 10, max = 50)
    @NotBlank(message = "password is required")
    private String password;

    @NotBlank(message = "Email is required")
    @Email
    private String email;

    private String role;
}
