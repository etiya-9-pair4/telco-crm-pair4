package com.etiya.customerservice.dto.IndividualCustomer.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {
    private Integer customerId;
    private long nationalityId;
    private String firstName;
    private String middleName;
    private String lastName;
    private Integer genderId;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime deletedDate;

}
