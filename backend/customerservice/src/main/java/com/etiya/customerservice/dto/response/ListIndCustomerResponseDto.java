package com.etiya.customerservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListIndCustomerResponseDto {
    private String firstName;
    private String middleName;
    private String lastName;
    private int nationalityId;
//    private LocalDateTime dateOfBirth;
//    private String motherName;
//    private String fatherName;
//    private Integer genderId;

}
