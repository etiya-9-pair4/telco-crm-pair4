package com.etiya.customerservice.dto.IndividualCustomer.response;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public class AddressResponse {

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
