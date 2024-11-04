package com.etiya.productservice.service.campaign;

import com.etiya.productservice.dto.campaign.request.CreateCampaignRequestDto;
import com.etiya.productservice.dto.campaign.request.UpdateCampaignRequestDto;
import com.etiya.productservice.dto.campaign.response.CampaignResponseDto;
import com.etiya.productservice.dto.campaign.response.CreateCampaignResponseDto;
import com.etiya.productservice.dto.campaign.response.DeleteCampaignResponseDto;
import com.etiya.productservice.dto.campaign.response.UpdateCampaignResponseDto;
import com.etiya.productservice.entity.Campaign;
import com.etiya.productservice.mapper.campaign.CampaignMapper;
import com.etiya.productservice.repository.campaign.CampaignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;
    private final CampaignMapper campaignMapper;

    @Override
    public CreateCampaignResponseDto add(CreateCampaignRequestDto createCampaignRequestDto) {
        Campaign campaign = campaignMapper.toCampaign(createCampaignRequestDto);
        Campaign savedCampaign = campaignRepository.save(campaign);
        return campaignMapper.toCreateCampaignResponseDto(savedCampaign);
    }

    @Override
    public UpdateCampaignResponseDto update(UpdateCampaignRequestDto updateCampaignRequestDto) {
        Campaign campaign = campaignMapper.toCampaign(updateCampaignRequestDto);
        Campaign updatedCampaign = campaignRepository.save(campaign);
        return campaignMapper.toUpdateCampaignResponseDto(updatedCampaign);
    }

    @Override
    public DeleteCampaignResponseDto deleteById(Integer id) {
        Optional<Campaign> campaignOptional  = campaignRepository.findById(id);
        if (!campaignOptional .isPresent()) {
            throw new RuntimeException("Campaign not found with ID: " + id);
        }

        Campaign campaign = campaignOptional.get();

        campaignRepository.deleteById(id);
        return campaignMapper.toDeleteCampaignResponseDto(campaignOptional.get());
    }

    @Override
    public CampaignResponseDto getById(Integer id) {
        Campaign campaign = campaignRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campaign not found"));
        return campaignMapper.toCampaignResponseDto(campaign);
    }

    @Override
    public List<CampaignResponseDto> getAll() {
        return campaignRepository.findAll().stream()
                .map(campaignMapper::toCampaignResponseDto)
                .collect(Collectors.toList());
    }
}
