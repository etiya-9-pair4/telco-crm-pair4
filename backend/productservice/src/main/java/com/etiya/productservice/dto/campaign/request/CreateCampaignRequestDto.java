package com.etiya.productservice.dto.campaign.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCampaignRequestDto {
    private String name;
    private boolean status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String campaignCode;
    private short discountRate;
}
