package com.etiya.customerservice.dto.Contact.request;


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
public class UpdateContactRequestDto {
    @NotNull
    private Integer contactId;
    @NotNull
    private Integer customerId;
    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private String mobilePhone;
    @NotNull
    @NotBlank
    private String homePhone;
    @NotNull
    @NotBlank
    private String faxNumber;
}
