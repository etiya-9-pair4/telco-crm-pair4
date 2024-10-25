package com.etiya.customerservice.dto.Address.request;


import com.etiya.customerservice.entity.Customer;
import com.etiya.customerservice.entity.CustomerAccount;
import com.etiya.customerservice.entity.District;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class CreateAddressRequestDto {
    @NotNull
    @NotBlank
    private Integer customerId;
    @NotNull
    @NotBlank
    private String street;
    @NotNull
    @NotBlank
    private String houseNumber;
    @NotNull
    @NotBlank
    private String description;
    @NotNull
    @NotBlank
    private boolean isDefault;
    @NotNull
    @NotBlank
    private Integer districtId;
}
