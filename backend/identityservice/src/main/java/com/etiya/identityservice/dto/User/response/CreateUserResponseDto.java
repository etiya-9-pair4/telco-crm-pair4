package com.etiya.identityservice.dto.User.response;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResponseDto {

    private int userName;
    private Integer titleId;
    private String email;
    private Integer wrongAttempts;
    private boolean isLocked;
    private String firstName;
    private String lastName;
}
