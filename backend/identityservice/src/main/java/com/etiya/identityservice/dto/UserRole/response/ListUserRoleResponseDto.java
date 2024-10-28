package com.etiya.identityservice.dto.UserRole.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ListUserRoleResponseDto {
    @NotNull
    @NotBlank
    private Integer userRoleId;
}
