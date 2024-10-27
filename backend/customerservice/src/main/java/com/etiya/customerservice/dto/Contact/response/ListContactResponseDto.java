package com.etiya.customerservice.dto.Contact.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListContactResponseDto {
    private Integer contactId;
    private Integer customerId;
    private String email;
    private String mobilePhone;
    private String homePhone;
    private String faxNumber;
}
