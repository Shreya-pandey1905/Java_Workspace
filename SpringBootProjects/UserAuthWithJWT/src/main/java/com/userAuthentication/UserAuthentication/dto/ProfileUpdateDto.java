package com.userAuthentication.UserAuthentication.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProfileUpdateDto {

    @NotBlank(message = "Username is required")
    @Size(message = "between 5 to 50", max = 5,min = 50)
    private String username;

    @Size(min = 10, max = 50)
    @NotBlank(message = "password is required")
    private String password;

    @NotBlank(message = "Email is required")
    @Email
    private String email;
}
