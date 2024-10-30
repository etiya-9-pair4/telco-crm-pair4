package com.etiya.identityservice.dto.role.request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RoleRequestDto {
    // Getter ve Setter
    private String name;

    public void setName(String name) { this.name = name; }
}
