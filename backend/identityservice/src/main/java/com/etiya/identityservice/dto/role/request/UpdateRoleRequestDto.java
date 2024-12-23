package com.etiya.identityservice.dto.role.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRoleRequestDto {
    @Positive
    private Integer Id;
    @NotNull
    @NotBlank
    private String name;
}
