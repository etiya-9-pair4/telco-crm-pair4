package com.etiya.identityservice.service.auth;

import com.etiya.identityservice.dto.auth.request.LoginRequestDto;
import com.etiya.identityservice.dto.auth.request.RegisterRequestDto;
import com.etiya.identityservice.dto.auth.response.LoginResponseDto;
import com.etiya.identityservice.dto.auth.response.RegisterResponseDto;
import com.etiya.identityservice.dto.auth.response.TokenResponseDto;

public interface AuthService  {
    TokenResponseDto login(LoginRequestDto loginRequest);

    TokenResponseDto register(RegisterRequestDto registerRequest);
}
