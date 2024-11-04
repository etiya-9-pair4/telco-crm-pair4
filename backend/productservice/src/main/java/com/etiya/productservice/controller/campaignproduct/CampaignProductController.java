package com.etiya.productservice.controller.campaignproduct;

import com.etiya.productservice.dto.campaignproduct.request.CreateCampaignProductRequestDto;
import com.etiya.productservice.dto.campaignproduct.request.DeleteCampaignProductRequestDto;
import com.etiya.productservice.dto.campaignproduct.request.UpdateCampaignProductRequestDto;
import com.etiya.productservice.dto.campaignproduct.response.CampaignProductResponseDto;
import com.etiya.productservice.dto.campaignproduct.response.CreateCampaignProductResponseDto;
import com.etiya.productservice.dto.campaignproduct.response.UpdateCampaignProductResponseDto;
import com.etiya.productservice.service.campaignproduct.CampaignProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campaign-products")
@RequiredArgsConstructor
public class CampaignProductController {
    private final CampaignProductService campaignProductService;

    @PostMapping
    public ResponseEntity<CreateCampaignProductResponseDto> createCampaignProduct(@RequestBody CreateCampaignProductRequestDto createCampaignProductRequestDto) {
        CreateCampaignProductResponseDto responseDto = campaignProductService.add(createCampaignProductRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping
    public ResponseEntity<UpdateCampaignProductResponseDto> updateCampaignProduct(@RequestBody UpdateCampaignProductRequestDto updateCampaignProductRequestDto) {
        UpdateCampaignProductResponseDto responseDto = campaignProductService.update(updateCampaignProductRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCampaignProduct(@RequestBody DeleteCampaignProductRequestDto deleteCampaignProductRequestDto) {
        campaignProductService.delete(deleteCampaignProductRequestDto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampaignProductResponseDto> getCampaignProductById(@PathVariable Integer id) {
        CampaignProductResponseDto responseDto = campaignProductService.getById(id);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<CampaignProductResponseDto>> getAllCampaignProducts() {
        List<CampaignProductResponseDto> responseDtos = campaignProductService.getAll();
        return ResponseEntity.ok(responseDtos);
    }
}
