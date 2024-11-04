package com.etiya.productservice.service.campaignproduct;

import com.etiya.productservice.dto.campaignproduct.request.CreateCampaignProductRequestDto;
import com.etiya.productservice.dto.campaignproduct.request.DeleteCampaignProductRequestDto;
import com.etiya.productservice.dto.campaignproduct.request.UpdateCampaignProductRequestDto;
import com.etiya.productservice.dto.campaignproduct.response.CampaignProductResponseDto;
import com.etiya.productservice.dto.campaignproduct.response.CreateCampaignProductResponseDto;
import com.etiya.productservice.dto.campaignproduct.response.UpdateCampaignProductResponseDto;

import java.util.List;

public interface CampaignProductService {
    // Create a new CampaignProduct
    CreateCampaignProductResponseDto add(CreateCampaignProductRequestDto createCampaignProductRequestDto);

    // Update an existing CampaignProduct
    UpdateCampaignProductResponseDto update(UpdateCampaignProductRequestDto updateCampaignProductRequestDto);

    // Delete a CampaignProduct by ID
    void delete(DeleteCampaignProductRequestDto deleteCampaignProductRequestDto);

    // Get a CampaignProduct by ID
    CampaignProductResponseDto getById(Integer id);

    // List all CampaignProducts
    List<CampaignProductResponseDto> getAll();
}
