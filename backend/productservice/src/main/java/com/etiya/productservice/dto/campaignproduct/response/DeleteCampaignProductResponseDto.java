package com.etiya.productservice.dto.campaignProduct.response;

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
public class DeleteCampaignProductResponseDto {
    private Integer id;
    private Campaign campaign;
    private Product product;
}