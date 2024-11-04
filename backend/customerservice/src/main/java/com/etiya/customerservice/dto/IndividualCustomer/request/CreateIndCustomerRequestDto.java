package com.etiya.customerservice.dto.IndividualCustomer.request;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateIndCustomerRequestDto {
    @NotNull
    private long nationalityId;
    @NotBlank
    @NotNull
    private String firstName;
    @NotBlank
    private String middleName;
    @NotBlank
    @NotNull
    private String lastName;
    @NotNull
    @Past
    private LocalDateTime dateOfBirth;
    @NotBlank
    @NotNull
    private String motherName;
    @NotBlank
    @NotNull
    private String fatherName;
    @Positive
    private Integer genderId;

}
