package com.etiya.identityservice.dto.auth.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    //@Pattern(regexp = "")
    private String password;

    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String surname;

    @NotNull
    @NotBlank
    @Size(min = 11, max = 11)
    private String identityNo;
}