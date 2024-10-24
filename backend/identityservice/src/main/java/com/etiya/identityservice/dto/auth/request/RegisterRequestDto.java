package com.etiya.identityservice.dto.auth.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.boot.convert.DataSizeUnit;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterRequestDto {

    @NotBlank
    @NotNull
    private String email;

    @NotBlank
    @NotNull
    //TODO:@Pattern(regexp = "")
    private String password;

    private String firstName;


    private String lastName;


}
