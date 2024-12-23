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
public class CreateCampaignProductRequestDto {
    @NotNull
    private Long campaignId;
    @NotNull
    private Long productId;
}