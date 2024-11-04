package com.etiya.productservice.service.campaign;

import com.etiya.productservice.dto.campaign.request.CreateCampaignRequestDto;
import com.etiya.productservice.dto.campaign.request.UpdateCampaignRequestDto;
import com.etiya.productservice.dto.campaign.response.CampaignResponseDto;
import com.etiya.productservice.dto.campaign.response.CreateCampaignResponseDto;
import com.etiya.productservice.dto.campaign.response.DeleteCampaignResponseDto;
import com.etiya.productservice.dto.campaign.response.UpdateCampaignResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CampaignService {
    // Campaign oluşturma metodu
    CreateCampaignResponseDto add(CreateCampaignRequestDto createCampaignRequestDto);

    // Campaign güncelleme metodu
    UpdateCampaignResponseDto update(UpdateCampaignRequestDto updateCampaignRequestDto);

    // Campaign silme metodu (id'ye göre)
    DeleteCampaignResponseDto deleteById(Integer id);

    // Campaign'i id'ye göre getirme metodu
    CampaignResponseDto getById(Integer id);

    // Tüm Campaign'leri listeleme metodu
    List<CampaignResponseDto> getAll();
}
