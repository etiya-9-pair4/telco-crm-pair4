package com.etiya.productservice.dto.campaign.response;

import com.etiya.productservice.dto.product.response.ProductResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListCampaignResponseDto {
    private CampaignResponseDto campaign;

}
