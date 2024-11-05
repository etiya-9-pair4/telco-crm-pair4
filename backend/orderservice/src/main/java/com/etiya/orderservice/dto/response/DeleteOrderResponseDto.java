package com.etiya.orderservice.dto.response;

import com.etiya.orderservice.dto.customer.Address;
import com.etiya.orderservice.dto.product.ProductDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteOrderResponseDto {

    @NotNull
    @NotBlank
    private String id;
    @NotNull
    @NotBlank
    private LocalDate createdDate;
    @NotNull
    @NotBlank
    private float totalPrice;
    @NotNull
    @NotBlank
    private List<ProductDto> products;
    @NotNull
    @NotBlank
    private List<Address> address;

}
