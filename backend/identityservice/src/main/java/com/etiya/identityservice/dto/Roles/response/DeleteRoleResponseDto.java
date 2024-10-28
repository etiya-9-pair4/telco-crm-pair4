package com.etiya.identityservice.dto.Roles.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteRoleResponseDto {
    @NotNull
    @NotBlank
    private Integer Id;
    private String name;
}
