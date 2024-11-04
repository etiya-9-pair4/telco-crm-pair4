package com.etiya.productservice.dto.campaignProduct.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCampaignProductResponseDto {
    private Integer id;
    private Long campaignId;
    private Long productId;
}
