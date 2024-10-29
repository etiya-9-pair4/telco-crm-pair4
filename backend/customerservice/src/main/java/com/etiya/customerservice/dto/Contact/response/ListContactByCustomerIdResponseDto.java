package com.etiya.customerservice.dto.Contact.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListContactByCustomerIdResponseDto {
    private Integer customerId;
    private Integer contactId;
    private String email;
    private String mobilePhone;
    private String homePhone;
    private String faxNumber;
}
