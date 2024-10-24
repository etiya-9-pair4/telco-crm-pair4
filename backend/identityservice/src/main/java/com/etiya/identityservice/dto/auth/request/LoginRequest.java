package com.etiya.identityservice.dto.auth.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest
{
    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private String password;
}