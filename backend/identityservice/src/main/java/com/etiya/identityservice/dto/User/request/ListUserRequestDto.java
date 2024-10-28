package com.etiya.identityservice.dto.User.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListUserRequestDto {
    private Integer userId;
    private int nationalityId;
    private String firstName;
    private String middleName;
    private String lastName;
}
