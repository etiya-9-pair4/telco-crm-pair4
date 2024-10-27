package com.etiya.customerservice.dto.Contact.response;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateContactResponseDto {
    private Integer contactId;
    private Integer customerId;
    private String email;
    private String mobilePhone;
    private String homePhone;
    private String faxNumber;
}
