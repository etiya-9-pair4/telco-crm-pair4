package com.etiya.identityservice.dto.auth.response;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponseDto {
    private String token;
    private boolean success;
}
