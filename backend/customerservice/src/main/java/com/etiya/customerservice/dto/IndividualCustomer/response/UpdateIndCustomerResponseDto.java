package com.etiya.customerservice.dto.IndividualCustomer.response;


import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateIndCustomerResponseDto {
    private long nationalityId;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDateTime dateOfBirth;
    private String motherName;
    private String fatherName;
    private Integer genderId;
    private LocalDateTime updatedDate;
}
