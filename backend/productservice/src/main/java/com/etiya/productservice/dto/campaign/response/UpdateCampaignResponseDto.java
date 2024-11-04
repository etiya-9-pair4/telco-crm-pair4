package com.etiya.productservice.dto.campaign.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCampaignResponseDto {
    private Integer id;
    private String name;
    private boolean status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String campaignCode;
    private short discountRate;
}
