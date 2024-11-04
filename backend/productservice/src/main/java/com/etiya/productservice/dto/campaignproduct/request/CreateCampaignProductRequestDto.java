package com.etiya.productservice.dto.campaignproduct.request;

import com.etiya.productservice.entity.Campaign;
import com.etiya.productservice.entity.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCampaignProductRequestDto {
    @NotNull(message = "Campaign cannot be null")
    private Campaign campaign;
    @NotNull(message = "Campaign cannot be null")
    private Product product;
}
