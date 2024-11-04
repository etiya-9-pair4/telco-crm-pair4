package com.etiya.customerservice.dto.IndividualCustomer.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchIndividualCustomerRequestDto {
    private Integer customerId;
    private Long nationalityId;
    private String accountNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobilePhone;
}

