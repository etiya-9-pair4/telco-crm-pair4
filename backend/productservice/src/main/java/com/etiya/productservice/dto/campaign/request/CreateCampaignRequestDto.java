package com.etiya.productservice.dto.campaign.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "Campaign name cannot be empty.")
    private String name;
    @NotNull(message = "Campaign status cannot be empty.")
    private boolean status;
    @NotNull(message = "Campaign start date cannot be empty.")
    private LocalDateTime startDate;
    @NotNull(message = "Campaign end date cannot be empty.")
    private LocalDateTime endDate;
    @NotNull(message = "Campaign code cannot be empty.")
    private String campaignCode;
    @NotNull(message = "Discount rate cannot be empty.")
    private short discountRate;
}
