package com.etiya.identityservice.dto.User.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteUserResponseDto {
    private int userName;
    private Integer titleId;
    private String email;

    private String firstName;
    private String lastName;
}
