package com.etiya.identityservice.service.auth;

import com.etiya.identityservice.dto.auth.request.LoginRequestDto;
import com.etiya.identityservice.dto.auth.request.RegisterRequestDto;
import com.etiya.identityservice.dto.auth.response.TokenResponseDto;
import com.etiya.identityservice.entity.User;
import com.etiya.identityservice.service.user.UserService;
import io.github.anilaygun.security.BaseJwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final BaseJwtService baseJwtService;

//    @Override
//    public LoginResponseDto login(LoginRequestDto loginRequest) {
//        UserDetails user = userService.loadUserByUsername(loginRequest.getEmail());
//        boolean passwordMatching = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());
//        if (!passwordMatching)
//            throw new RuntimeException("E-posta veya şifre hatalı.");
//
//        String token = baseJwtService.generateToken(user.getUsername());
//        LoginResponseDto responseDto = new LoginResponseDto();
//        responseDto.setEmail(loginRequest.getEmail());
//        responseDto.setTokenResponse(new TokenResponseDto(token, true));
//        return responseDto;
//    }

//    @Override
//    public RegisterResponseDto register(RegisterRequestDto requestDto) {
//        User user = new User();
//        user.setEmail(requestDto.getEmail());
//        String token = baseJwtService.generateToken(user.getEmail());
//        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
//        userService.create(user);
//
//        RegisterResponseDto responseDto = new RegisterResponseDto();
//        responseDto.setEmail(user.getEmail());
//        responseDto.setTokenResponse(new TokenResponseDto(token, true));
//        return responseDto;
//    }

    @Override
    public TokenResponseDto login(LoginRequestDto loginRequest) {
        UserDetails user = userService.loadUserByUsername(loginRequest.getEmail());
        boolean passwordMatching = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());
        if (!passwordMatching) throw new RuntimeException("E-posta veya şifre hatalı.");
        return new TokenResponseDto(baseJwtService.generateToken(user.getUsername()), true);
    }

    @Override
    public TokenResponseDto register(RegisterRequestDto registerRequest) {
        User userToAdd = new User();
        userToAdd.setEmail(registerRequest.getEmail());
        userToAdd.setFirstName(registerRequest.getFirstName());
        userToAdd.setLastName(registerRequest.getLastName());
       // userToAdd.setIdentityNo(registerRequest.getIdentityNo());
        userToAdd.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        User user = userService.create(userToAdd);
        return new TokenResponseDto(baseJwtService.generateToken(user.getUsername()), true);
    }
}
