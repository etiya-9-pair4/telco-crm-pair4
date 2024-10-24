package com.etiya.identityservice.dto.auth.response;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponseDto {
    private String token;
    private boolean success;
}
