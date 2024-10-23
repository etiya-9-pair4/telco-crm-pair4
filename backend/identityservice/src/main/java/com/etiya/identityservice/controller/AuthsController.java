package com.etiya.identityservice.controller;


import com.etiya.identityservice.dto.auth.request.LoginRequestDto;
import com.etiya.identityservice.dto.auth.request.RegisterRequestDto;
import com.etiya.identityservice.dto.auth.response.LoginResponseDto;
import com.etiya.identityservice.dto.auth.response.RegisterResponseDto;
import com.etiya.identityservice.service.auth.AuthService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor

public class AuthsController {
    private final AuthService authService;


    @PostMapping("login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }


    @PostMapping("register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterRequestDto registerRequest) {
        return ResponseEntity.ok(authService.register(registerRequest));
    }
}
