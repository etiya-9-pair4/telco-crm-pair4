package com.etiya.identityservice.dto.auth.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.boot.convert.DataSizeUnit;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDto {

    @NotBlank
    @NotNull
    private String email;
    @NotBlank
    @NotNull
    //TODO:@Pattern(regexp = "")
    private String password;
    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String lastName;
}
