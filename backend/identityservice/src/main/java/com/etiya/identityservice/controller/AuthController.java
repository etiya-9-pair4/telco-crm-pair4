package com.etiya.identityservice.controller;

import com.etiya.identityservice.dto.auth.request.LoginRequest;
import com.etiya.identityservice.dto.auth.request.LoginRequestDto;
import com.etiya.identityservice.dto.auth.request.RegisterRequest;
import com.etiya.identityservice.dto.auth.request.RegisterRequestDto;
import com.etiya.identityservice.dto.auth.response.TokenResponse;
import com.etiya.identityservice.dto.auth.response.TokenResponseDto;
import com.etiya.identityservice.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
//@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class AuthController {
    private final AuthService authService;

    @PostMapping("login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody LoginRequestDto loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }


    @PostMapping("register")
    public ResponseEntity<TokenResponseDto> register(@RequestBody RegisterRequestDto registerRequest){
        return ResponseEntity.ok(authService.register(registerRequest));
    }
}