package com.etiya.customerservice.dto.Contact.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteContactResponseDto {
    private Integer contactId;
    private Integer customerId;
    private String email;
    private String mobilePhone;
    private String homePhone;
    private String faxNumber;
}
