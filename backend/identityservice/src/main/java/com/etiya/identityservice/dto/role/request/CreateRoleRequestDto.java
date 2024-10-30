package com.etiya.identityservice.dto.role.request;
import jakarta.validation.constraints.Positive;
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
