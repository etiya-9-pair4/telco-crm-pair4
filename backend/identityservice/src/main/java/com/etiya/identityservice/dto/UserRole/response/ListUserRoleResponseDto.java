package com.etiya.identityservice.dto.userRole.response;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
public class ListUserRoleResponseDto {
    @NotNull
    @NotBlank
    private Integer userRoleId;
}
