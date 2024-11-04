package com.etiya.customerservice.dto.IndividualCustomer.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteIndCustomerResponseDto {
    private Integer customerId;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDateTime createdDate;
    private LocalDateTime deletedDate;

}
