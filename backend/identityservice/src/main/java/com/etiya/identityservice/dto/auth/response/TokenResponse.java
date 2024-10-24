package com.etiya.identityservice.dto.auth.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponse {
    private String token;
    private boolean success;
}