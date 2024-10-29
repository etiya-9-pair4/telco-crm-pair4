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

    @PutMapping()
    public ResponseEntity<UpdateAddressResponseDto> updateAddress(@RequestBody @Valid UpdateAddressRequestDto updateAddressRequestDto) {
        UpdateAddressResponseDto responseDto = addressService.update(updateAddressRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping
    public ResponseEntity<DeleteAddressResponseDto> deleteAddress(@RequestBody @Valid DeleteAddressRequestDto deleteAddressRequestDto) {
        DeleteAddressResponseDto responseDto = addressService.delete(deleteAddressRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping()
    public ResponseEntity<Optional<ListAddressResponseDto>> getById(@RequestParam Integer addressId) {
        Optional<ListAddressResponseDto> address = addressService.getById(addressId);
        return ResponseEntity.ok(address);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ListAddressResponseDto>> getAll() {
        List<ListAddressResponseDto> addresses = addressService.getAll();
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<ListAddressByCustomerIdResponseDto>> getAddressesByCustomerId(@PathVariable Integer customerId) {
        List<ListAddressByCustomerIdResponseDto> addresses = addressService.findByCustomerId(customerId);
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/{customerId}/default")
    public ResponseEntity<ListAddressByCustomerIdResponseDto> getDefaultAddressByCustomerId(@PathVariable Integer customerId) {
        Optional<ListAddressByCustomerIdResponseDto> addressOptional = addressService.findByCustomerIdAndIsDefaultTrue(customerId);
        return addressOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
