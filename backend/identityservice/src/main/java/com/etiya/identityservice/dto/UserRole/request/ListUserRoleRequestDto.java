package com.etiya.identityservice.dto.userRole.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
public class ListUserRoleRequestDto {
    @Positive
    private Integer Id;
}