package com.etiya.productservice.mapper;

import com.etiya.productservice.dto.campaign.request.CreateCampaignRequestDto;
import com.etiya.productservice.entity.Campaign;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CampaignMapper {
    Campaign toCampaign (CreateCampaignRequestDto createCampaignRequestDto);
}
