package com.etiya.productservice.service.campaignProduct;



import com.etiya.productservice.dto.campaignProduct.request.CreateCampaignProductRequestDto;
import com.etiya.productservice.dto.campaignProduct.request.DeleteCampaignProductRequestDto;
import com.etiya.productservice.dto.campaignProduct.request.UpdateCampaignProductRequestDto;
import com.etiya.productservice.dto.campaignProduct.response.CampaignProductResponseDto;
import com.etiya.productservice.dto.campaignProduct.response.CreateCampaignProductResponseDto;
import com.etiya.productservice.dto.campaignProduct.response.UpdateCampaignProductResponseDto;

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
