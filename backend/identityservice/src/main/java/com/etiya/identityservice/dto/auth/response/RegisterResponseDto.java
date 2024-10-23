package com.etiya.identityservice.dto.auth.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponseDto {
    private String firstName;
    private String lastName;
    private String email;
    private TokenResponseDto tokenResponse;
}
