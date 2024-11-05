package com.etiya.customerservice.dto.IndividualCustomer.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class AddressRequest {

    @NotBlank
    private Integer id;
    @NotBlank
    private String street;
    @NotBlank
    private String houseNumber;
    @NotBlank
    private String description;
    @NotBlank
    private boolean isDefault;
}
