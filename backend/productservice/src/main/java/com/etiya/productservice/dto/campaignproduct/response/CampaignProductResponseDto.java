package com.etiya.productservice.dto.campaignproduct.response;

import com.etiya.productservice.entity.Campaign;
import com.etiya.productservice.entity.Product;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CampaignProductResponseDto {
    private Integer id;
    private Campaign campaign;
    private Product product;
}
