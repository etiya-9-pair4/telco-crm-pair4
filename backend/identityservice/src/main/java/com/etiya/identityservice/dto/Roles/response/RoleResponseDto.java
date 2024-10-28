package com.etiya.identityservice.dto.Roles.response;

public class RoleResponseDto {
    private Integer id;
    private String name;

    // Getter ve Setter
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

