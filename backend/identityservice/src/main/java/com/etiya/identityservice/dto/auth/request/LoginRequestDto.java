package com.etiya.identityservice.dto.auth.request;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginRequestDto {

    //    @NotBlank
    private String email;
    //    @NotBlank
    private String password;
}
