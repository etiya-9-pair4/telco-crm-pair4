package com.etiya.productservice.dto.campaignproduct.response;

import com.etiya.productservice.entity.Campaign;
import com.etiya.productservice.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCampaignProductResponseDto {
    private Integer id;
    private Campaign campaign;
    private Product product;
}
