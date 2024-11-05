package com.etiya.orderservice.dto.request;

import com.etiya.orderservice.dto.customer.*;
import com.etiya.orderservice.dto.product.*;
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
public class CreateOrderRequestDto {

    private Integer customerId;
    private List<ProductDto> products;

}