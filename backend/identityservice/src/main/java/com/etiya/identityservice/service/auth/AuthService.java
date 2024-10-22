package com.etiya.identityservice.service.auth;

import com.etiya.identityservice.dto.auth.request.LoginRequestDto;
import com.etiya.identityservice.dto.auth.request.RegisterRequestDto;
import com.etiya.identityservice.dto.auth.response.LoginResponseDto;
import com.etiya.identityservice.dto.auth.response.RegisterResponseDto;

public interface AuthService {
    LoginResponseDto login(LoginRequestDto loginRequest);

    RegisterResponseDto register(RegisterRequestDto registerRequest);
}
