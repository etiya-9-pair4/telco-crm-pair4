package com.etiya.customerservice.controller.CustomerController.IndividualCustomer;

import com.etiya.customerservice.dto.IndividualCustomer.request.CreateIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.DeleteIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.UpdateIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.CreateIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.DeleteIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.ListIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.UpdateIndCustomerResponseDto;
import com.etiya.customerservice.entity.Customer;
import com.etiya.customerservice.service.CustomerService.IndividualCustomer.IndividualCustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/individualcustomers")
@RequiredArgsConstructor
public class IndividualCustomerController {
    private final IndividualCustomerService individualCustomerService;

    @PostMapping
    public ResponseEntity<CreateIndCustomerResponseDto> addCustomer(@RequestBody @Valid CreateIndCustomerRequestDto createIndCustomerRequestDto) {
        CreateIndCustomerResponseDto responseDto = individualCustomerService.add(createIndCustomerRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping
    public ResponseEntity<UpdateIndCustomerResponseDto> updateCustomer(
            @RequestBody @Valid UpdateIndCustomerRequestDto updateIndCustomerRequestDto) {
//        updateIndCustomerRequestDto.setCustomerId(customerId); // URL'den alınan ID'yi ayarlayın
        UpdateIndCustomerResponseDto responseDto = individualCustomerService.update(updateIndCustomerRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping
    public ResponseEntity<DeleteIndCustomerResponseDto> deleteCustomer(@RequestBody @Valid DeleteIndCustomerRequestDto deleteRequestDto) {
        DeleteIndCustomerResponseDto responseDto = individualCustomerService.delete(deleteRequestDto);
        return ResponseEntity.ok(responseDto);
    }
    @GetMapping("/{customerId}")
    public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable Integer customerId) {
        Optional<Customer> customer = individualCustomerService.getCustomerById(customerId);
        return ResponseEntity.ok(customer);
    }

    @GetMapping
    public ResponseEntity<List<ListIndCustomerResponseDto>> getAllCustomers() {
        List<ListIndCustomerResponseDto> customers = individualCustomerService.getAll();
        return ResponseEntity.ok(customers);
    }
}
