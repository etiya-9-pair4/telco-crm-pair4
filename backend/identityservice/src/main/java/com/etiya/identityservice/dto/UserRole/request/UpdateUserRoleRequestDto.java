package com.etiya.identityservice.dto.userRole.request;
import jakarta.validation.constraints.Positive;
import jdk.jfr.BooleanFlag;
public class UpdateUserRoleRequestDto {
    @Positive
    private Integer roleId;
    @Positive
    private Integer userId;
    @BooleanFlag
    private boolean isCustom;
}