package com.etiya.identityservice.dto.user.response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListUserResponseDto {
    private int userName;
    private Integer titleId;
    private String email;
    private String firstName;
    private String lastName;
}
