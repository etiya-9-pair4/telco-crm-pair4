package com.etiya.orderservice.dto.request;

import com.etiya.orderservice.dto.product.ProductDto;
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
public class UpdateOrderRequestDto {
    @NotNull
    private Integer customerId;
    @NotBlank
    @NotNull
    private List<ProductDto> products;
}
