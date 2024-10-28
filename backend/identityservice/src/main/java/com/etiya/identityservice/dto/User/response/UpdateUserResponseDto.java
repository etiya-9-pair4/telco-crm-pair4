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
public class UpdateUserResponseDto {
    @NotBlank
    @NotNull
    private int userName;
    @NotBlank
    @NotNull
    private Integer titleId;
    @NotBlank
    @NotNull
    private String email;
    @PositiveOrZero
    private Integer wrongAttempts;
    private boolean isLocked;
    @NotBlank
    @NotNull
    private String firstName;
    @NotBlank
    @NotNull
    private String lastName;
}
