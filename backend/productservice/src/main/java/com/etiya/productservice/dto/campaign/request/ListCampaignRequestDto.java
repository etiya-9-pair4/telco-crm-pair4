package com.etiya.productservice.dto.campaign.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListCampaignRequestDto {
    @NotNull(message = "Campaign ID cannot be null.")
    private Integer campaignId;
}
