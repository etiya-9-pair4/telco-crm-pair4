package com.etiya.productservice.service.campaignProduct;


import com.etiya.productservice.dto.campaignProduct.request.CreateCampaignProductRequestDto;
import com.etiya.productservice.dto.campaignProduct.request.DeleteCampaignProductRequestDto;
import com.etiya.productservice.dto.campaignProduct.request.UpdateCampaignProductRequestDto;
import com.etiya.productservice.dto.campaignProduct.response.CampaignProductResponseDto;
import com.etiya.productservice.dto.campaignProduct.response.CreateCampaignProductResponseDto;
import com.etiya.productservice.dto.campaignProduct.response.UpdateCampaignProductResponseDto;
import com.etiya.productservice.entity.CampaignProduct;
import com.etiya.productservice.mapper.campaignProduct.CampaignProductMapper;
import com.etiya.productservice.repository.campaignProduct.CampaignProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CampaignProductServiceImpl implements CampaignProductService{
    private final CampaignProductRepository campaignProductRepository;
    private final CampaignProductMapper campaignProductMapper;

    @Override
    public CreateCampaignProductResponseDto add(CreateCampaignProductRequestDto createCampaignProductRequestDto) {
        CampaignProduct campaignProduct = campaignProductMapper.toCampaignProduct(createCampaignProductRequestDto);
        CampaignProduct savedCampaignProduct = campaignProductRepository.save(campaignProduct);
        return campaignProductMapper.toCreateCampaignProductResponseDto(savedCampaignProduct);
    }

    @Override
    public UpdateCampaignProductResponseDto update(UpdateCampaignProductRequestDto updateCampaignProductRequestDto) {
        Optional<CampaignProduct> campaignProductOptional  = campaignProductRepository.findById(updateCampaignProductRequestDto.getId());
        if (!campaignProductOptional.isPresent()){
            throw new RuntimeException("CampaignProduct not found with ID" + updateCampaignProductRequestDto.getId());
        }

        CampaignProduct existingCampaignProduct = campaignProductOptional.get();
        campaignProductMapper.toUpdateCampaignProductResponseDto(existingCampaignProduct);

        CampaignProduct updatedCampaign = campaignProductRepository.save(existingCampaignProduct);
        return campaignProductMapper.toUpdateCampaignProductResponseDto(updatedCampaign);

    }

    @Override
    public void delete(DeleteCampaignProductRequestDto deleteCampaignProductRequestDto) {
        Integer id = deleteCampaignProductRequestDto.getId();
        if (!campaignProductRepository.existsById(id)) {
            throw new RuntimeException("CampaignProduct not found with ID: " + id);
        }
        campaignProductRepository.deleteById(id);
    }

    @Override
    public CampaignProductResponseDto getById(Integer id) {
        CampaignProduct campaignProduct = campaignProductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CampaignProduct not found with ID: " + id));

        return campaignProductMapper.toCampaignProductResponseDto(campaignProduct);
    }
    @Override
    public List<CampaignProductResponseDto> getAll() {
        List<CampaignProduct> campaignProducts = campaignProductRepository.findAll();
        return campaignProducts.stream()
                .map(campaignProductMapper::toCampaignProductResponseDto)
                .collect(Collectors.toList());
    }
}
