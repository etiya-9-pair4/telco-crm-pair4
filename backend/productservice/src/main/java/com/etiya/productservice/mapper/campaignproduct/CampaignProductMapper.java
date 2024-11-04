package com.etiya.productservice.mapper.campaignproduct;

import com.etiya.productservice.dto.campaignproduct.request.CreateCampaignProductRequestDto;
import com.etiya.productservice.dto.campaignproduct.request.UpdateCampaignProductRequestDto;
import com.etiya.productservice.dto.campaignproduct.response.*;
import com.etiya.productservice.entity.CampaignProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CampaignProductMapper {


    // CreateCampaignProductRequestDto'dan CampaignProduct entity'ye dönüştürme
    @Mapping(target = "id", ignore = true)
    CampaignProduct toCampaignProduct(CreateCampaignProductRequestDto createCampaignProductRequestDto);

    // CampaignProduct entity'den CreateCampaignProductResponseDto'ya dönüştürme
    CreateCampaignProductResponseDto toCreateCampaignProductResponseDto(CampaignProduct campaignProduct);

    // UpdateCampaignProductRequestDto'dan CampaignProduct entity'ye dönüştürme
    CampaignProduct toCampaignProduct(UpdateCampaignProductRequestDto updateCampaignProductRequestDto);

    // CampaignProduct entity'den UpdateCampaignProductResponseDto'ya dönüştürme
    UpdateCampaignProductResponseDto toUpdateCampaignProductResponseDto(CampaignProduct campaignProduct);

    // CampaignProduct entity'den DeleteCampaignProductResponseDto'ya dönüştürme
    DeleteCampaignProductResponseDto toDeleteCampaignProductResponseDto(CampaignProduct campaignProduct);

    // CampaignProduct entity'den CampaignProductResponseDto'ya dönüştürme
    CampaignProductResponseDto toCampaignProductResponseDto(CampaignProduct campaignProduct);

    // CampaignProduct entity'den ListCampaignProductResponseDto'ya dönüştürme
    ListCampaignProductResponseDto toListCampaignProductResponseDto(CampaignProduct campaignProduct);

}
