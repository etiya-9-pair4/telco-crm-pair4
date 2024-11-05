package com.etiya.orderservice.dto.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @NotNull
    @NotBlank
    private Integer id;
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

}

