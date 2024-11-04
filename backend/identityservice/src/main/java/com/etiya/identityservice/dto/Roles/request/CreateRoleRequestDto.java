package com.etiya.identityservice.dto.Roles.request;

import jakarta.validation.constraints.Positive;
import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateRoleRequestDto {
    @Positive
    private Integer id;

    private String name;

}
