package com.etiya.identityservice.dto.UserRole.response;

import jakarta.validation.constraints.Positive;
import jdk.jfr.BooleanFlag;

public class CreateUserRoleResponseDto {
    @Positive
    private Integer id;
    @Positive
    private Integer roleId;
    @Positive
    private Integer userId;
    @BooleanFlag
    private boolean isCustom;
}