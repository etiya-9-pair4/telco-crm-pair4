package com.etiya.identityservice.dto.UserRole.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class DeleteUserRoleRequestDto {
    @Positive
    private Integer Id;
}
