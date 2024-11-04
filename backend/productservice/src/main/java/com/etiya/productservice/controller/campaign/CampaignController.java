package com.etiya.productservice.controller.campaign;

import com.etiya.productservice.dto.campaign.request.CreateCampaignRequestDto;
import com.etiya.productservice.dto.campaign.request.UpdateCampaignRequestDto;
import com.etiya.productservice.dto.campaign.response.CampaignResponseDto;
import com.etiya.productservice.dto.campaign.response.CreateCampaignResponseDto;
import com.etiya.productservice.dto.campaign.response.DeleteCampaignResponseDto;
import com.etiya.productservice.dto.campaign.response.UpdateCampaignResponseDto;
import com.etiya.productservice.service.campaign.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campaigns")
@RequiredArgsConstructor
public class CampaignController {
    private final CampaignService campaignService;

    @PostMapping
    public ResponseEntity<CreateCampaignResponseDto> createCampaign(@RequestBody CreateCampaignRequestDto createCampaignRequestDto) {
        CreateCampaignResponseDto responseDto = campaignService.add(createCampaignRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping
    public ResponseEntity<UpdateCampaignResponseDto> updateCampaign(@RequestBody UpdateCampaignRequestDto updateCampaignRequestDto) {
        UpdateCampaignResponseDto responseDto = campaignService.update(updateCampaignRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteCampaignResponseDto> deleteCampaign(@PathVariable Integer id) {
        DeleteCampaignResponseDto responseDto = campaignService.deleteById(id);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampaignResponseDto> getCampaignById(@PathVariable Integer id) {
        CampaignResponseDto responseDto = campaignService.getById(id);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<CampaignResponseDto>> getAllCampaigns() {
        List<CampaignResponseDto> responseDtos = campaignService.getAll();
        return ResponseEntity.ok(responseDtos);
    }
}
