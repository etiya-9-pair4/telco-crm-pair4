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
    private Integer customerId;
    private long nationalityId;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDateTime dateOfBirth;
    private String motherName;
    private String fatherName;
    @Positive
    private Integer genderId;
//    @NotBlank
//    @Positive
//    private Integer addressId;
//    @NotBlank
//    @Positive
//    private Integer contactId;
}
