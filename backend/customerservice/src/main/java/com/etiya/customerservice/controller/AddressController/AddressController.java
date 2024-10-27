package com.etiya.customerservice.controller.AddressController;

import com.etiya.customerservice.dto.Address.request.CreateAddressRequestDto;
import com.etiya.customerservice.dto.Address.request.DeleteAddressRequestDto;
import com.etiya.customerservice.dto.Address.request.UpdateAddressRequestDto;
import com.etiya.customerservice.dto.Address.response.*;
import com.etiya.customerservice.service.AddressService.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<CreateAddressResponseDto> createAddress(@RequestBody @Valid CreateAddressRequestDto createAddressRequestDto) {
        CreateAddressResponseDto responseDto = addressService.add(createAddressRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<UpdateAddressResponseDto> updateAddress(@PathVariable Integer addressId, @RequestBody @Valid UpdateAddressRequestDto updateAddressRequestDto) {
        updateAddressRequestDto.setAddressId(addressId); // ID'yi ayarlayın
        UpdateAddressResponseDto responseDto = addressService.update(updateAddressRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping
    public ResponseEntity<DeleteAddressResponseDto> deleteAddress(@RequestBody @Valid DeleteAddressRequestDto deleteAddressRequestDto) {
        DeleteAddressResponseDto responseDto = addressService.delete(deleteAddressRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<Optional<ListAddressResponseDto>> getAddressById(@PathVariable Integer addressId) {
        Optional<ListAddressResponseDto> address = addressService.getAddressById(addressId);
        return ResponseEntity.ok(address);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<ListAddressByCustomerIdResponseDto>> getAllAddressesByCustomerId(@PathVariable Integer customerId) {
        List<ListAddressByCustomerIdResponseDto> addresses = addressService.getAllAddressesByCustomerId(customerId);
        return ResponseEntity.ok(addresses);
    }
}
