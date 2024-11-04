package com.etiya.productservice.mapper.campaign;

import com.etiya.productservice.dto.campaign.request.CreateCampaignRequestDto;
import com.etiya.productservice.dto.campaign.request.UpdateCampaignRequestDto;
import com.etiya.productservice.dto.campaign.response.*;
import com.etiya.productservice.entity.Campaign;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CampaignMapper {
    // CreateCampaignRequestDto'dan Campaign entity'ye dönüştürme
    @Mapping(target = "id", ignore = true) // ID, create işleminde otomatik olarak oluşturulur
    Campaign toCampaign(CreateCampaignRequestDto createCampaignRequestDto);

    // Campaign entity'den CreateCampaignResponseDto'ya dönüştürme
    CreateCampaignResponseDto toCreateCampaignResponseDto(Campaign campaign);

    // UpdateCampaignRequestDto'dan Campaign entity'ye dönüştürme
    Campaign toCampaign(UpdateCampaignRequestDto updateCampaignRequestDto);

    // Campaign entity'den UpdateCampaignResponseDto'ya dönüştürme
    UpdateCampaignResponseDto toUpdateCampaignResponseDto(Campaign campaign);

    // Campaign entity'den DeleteCampaignResponseDto'ya dönüştürme
    DeleteCampaignResponseDto toDeleteCampaignResponseDto(Campaign campaign);

    // Campaign entity'den CampaignResponseDto'ya dönüştürme
    CampaignResponseDto toCampaignResponseDto(Campaign campaign);

    // Campaign entity'den ListCampaignResponseDto'ya dönüştürme
    ListCampaignResponseDto toListCampaignResponseDto(Campaign campaign);
}
