package com.etiya.productservice.dto.campaignproduct.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCampaignProductRequestDto {
    @NotNull(message = "Campaign Product Id cannot be null")
    private Integer id;
}
