package com.etiya.identityservice.dto.role.response;
import jakarta.validation.constraints.Positive;
import jdk.jfr.BooleanFlag;
public class UpdateRoleResponseDto {
    @Positive
    private Integer id;
    @Positive
    private Integer roleId;
    @Positive
    private Integer userId;
    @BooleanFlag
    private boolean isCustom;
}