package com.etiya.customerservice.controller;

import com.etiya.customerservice.dto.Address.response.ListAddressResponseDto;
import com.etiya.customerservice.dto.CustomerAccount.request.*;
import com.etiya.customerservice.dto.CustomerAccount.response.*;
import com.etiya.customerservice.service.CustomerAccountService.CustomerAccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer-accounts")
@RequiredArgsConstructor
public class CustomerAccountsController {

    private final CustomerAccountService customerAccountService;

    @PostMapping
    public ResponseEntity<CreateCustomerAccountResponseDto> createCustomerAccount(@RequestBody @Valid CreateCustomerAccountRequestDto requestDto) {
        CreateCustomerAccountResponseDto responseDto = customerAccountService.add(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping()
    public ResponseEntity<UpdateCustomerAccountResponseDto> updateCustomerAccount(@RequestBody @Valid UpdateCustomerAccountRequestDto requestDto) {
        UpdateCustomerAccountResponseDto responseDto = customerAccountService.update(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping()
    public ResponseEntity<DeleteCustomerAccountResponseDto> deleteCustomerAccount(@RequestBody @Valid DeleteCustomerAccountRequestDto requestDto) {
        DeleteCustomerAccountResponseDto responseDto = customerAccountService.delete(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/getById")
    public ResponseEntity<Optional<ListCustomerAccountResponseDto>> getCustomerAccountById(@RequestBody @Valid ListCustomerAccountRequestDto requestDto) {
        Optional<ListCustomerAccountResponseDto> cusromerAccounts = customerAccountService.getById(requestDto);
        return ResponseEntity.ok(cusromerAccounts);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<ListCustomerAccountResponseDto>> getAllCustomerAccounts() {
        List<ListCustomerAccountResponseDto> responseDtos = customerAccountService.getAll();
        return ResponseEntity.ok(responseDtos);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<ListCustomerAccountByCustomerIdResponseDto>> getAccountsByCustomerId(@PathVariable Integer customerId) {
        List<ListCustomerAccountByCustomerIdResponseDto> responseDtos = customerAccountService.findByCustomerId(customerId);
        return ResponseEntity.ok(responseDtos);
    }
}
