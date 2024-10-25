package com.etiya.customerservice.dto.IndividualCustomer.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class UpdateIndCustomerRequestDto {
    @NotNull
    @NotBlank
    private Integer customerId;
    @NotBlank
    @NotNull
    private String firstName;
    private String middleName;
    @NotBlank
    @NotNull
    private String lastName;
    @NotBlank
    @NotNull
    private LocalDateTime dateOfBirth;
    @NotBlank
    @NotNull
    private String motherName;
    @NotBlank
    @NotNull
    private String fatherName;
    @NotBlank
    @Positive
    private Integer genderId;
//    @NotBlank
//    @Positive
//    private Integer addressId;
//    @NotBlank
//    @Positive
//    private Integer contactId;
}
