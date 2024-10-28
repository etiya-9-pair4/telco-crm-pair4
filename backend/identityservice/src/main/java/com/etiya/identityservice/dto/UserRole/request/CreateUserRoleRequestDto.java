package com.etiya.identityservice.dto.UserRole.request;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jdk.jfr.BooleanFlag;

public class CreateUserRoleRequestDto {
    @Positive
    private Integer id;
    @Positive
    private Integer roleId;
    @Positive
    private Integer userId;
    @BooleanFlag
    private boolean isCustom;
}
