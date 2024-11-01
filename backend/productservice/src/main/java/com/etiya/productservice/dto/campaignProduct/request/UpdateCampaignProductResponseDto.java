package com.etiya.productservice.dto.campaignProduct.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCampaignProductResponseDto {
    @NotNull
    private Integer id;
    @NotNull
    private Long campaignId;
    @NotNull
    private Long productId;
}