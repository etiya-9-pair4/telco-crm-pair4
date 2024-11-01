package com.etiya.identityservice.dto.role.request;
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
public class DeleteRoleRequestDto {
    @NotNull
    @NotBlank
    private Integer Id;
}
