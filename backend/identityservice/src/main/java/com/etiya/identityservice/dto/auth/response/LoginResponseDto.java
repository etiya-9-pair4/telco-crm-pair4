package com.etiya.identityservice.dto.auth.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {
    private String email;
    private TokenResponseDto tokenResponse;
}
