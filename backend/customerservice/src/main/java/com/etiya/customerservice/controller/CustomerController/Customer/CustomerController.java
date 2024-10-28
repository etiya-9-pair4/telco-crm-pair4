package com.etiya.customerservice.controller.CustomerController.Customer;

import com.etiya.customerservice.dto.Customer.request.CreateCustomerRequestDto;
import com.etiya.customerservice.dto.Customer.request.DeleteCustomerRequestDto;
import com.etiya.customerservice.dto.Customer.request.UpdateCustomerRequestDto;
import com.etiya.customerservice.dto.Customer.response.CreateCustomerResponseDto;
import com.etiya.customerservice.dto.Customer.response.CustomerResponseDto;
import com.etiya.customerservice.dto.Customer.response.DeleteCustomerResponseDto;
import com.etiya.customerservice.dto.Customer.response.UpdateCustomerResponseDto;
import com.etiya.customerservice.service.CustomerService.Customer.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CreateCustomerResponseDto> createCustomer(@RequestBody @Valid CreateCustomerRequestDto request) {
        CreateCustomerResponseDto response = customerService.add(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<UpdateCustomerResponseDto> updateCustomer(
            @PathVariable Integer customerId,
            @RequestBody @Valid UpdateCustomerRequestDto request) {
        request.setCustomerId(customerId); // URL'den alınan customerId'yi ayarlayın
        UpdateCustomerResponseDto response = customerService.update(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<DeleteCustomerResponseDto> deleteCustomer(@PathVariable Integer customerId) {
        DeleteCustomerRequestDto request = new DeleteCustomerRequestDto(customerId);
        DeleteCustomerResponseDto response = customerService.delete(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponseDto> getCustomerById(@PathVariable Integer customerId) {
        Optional<CustomerResponseDto> customer = customerService.getById(customerId);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> getAllCustomers() {
        List<CustomerResponseDto> customers = customerService.getAll();
        return ResponseEntity.ok(customers);
    }
}
