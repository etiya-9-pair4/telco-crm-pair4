package com.etiya.identityservice.dto.Roles.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RoleRequestDto {
    private String name;

    // Getter ve Setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

