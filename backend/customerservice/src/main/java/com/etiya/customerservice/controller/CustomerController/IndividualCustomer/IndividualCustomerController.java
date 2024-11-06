package com.etiya.customerservice.controller.CustomerController.IndividualCustomer;

import com.etiya.customerservice.dto.IndividualCustomer.request.*;
import com.etiya.customerservice.dto.IndividualCustomer.response.*;
import com.etiya.customerservice.entity.Customer;
import com.etiya.customerservice.entity.IndividualCustomer;
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
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class IndividualCustomerController {
    private final IndividualCustomerService individualCustomerService;

    @PostMapping("/search")
    public ResponseEntity<List<SearchIndividualCustomerResponseDto>> searchCustomers(
            @RequestBody SearchIndividualCustomerRequestDto searchDto) {
        List<SearchIndividualCustomerResponseDto> results = individualCustomerService.searchCustomers(searchDto);
        return ResponseEntity.ok(results);
    }

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

//    @GetMapping("/{customerId}") // For OpenFeign
//    public ResponseEntity<IndividualCustomer> getCustomerById(@PathVariable Integer customerId) {
//        IndividualCustomer individualCustomer = individualCustomerService.getCustomerById(customerId);
//        return ResponseEntity.ok(individualCustomer);
//    }

    @PostMapping("/getById")
    public ResponseEntity<CustomerResponseDto> getById(@RequestBody @Valid ListIndCustomerRequestDto listIndCustomerRequestDto) {
        CustomerResponseDto responseDto = individualCustomerService.getById(listIndCustomerRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<ListIndCustomerResponseDto>> getAllCustomers() {
        List<ListIndCustomerResponseDto> customers = individualCustomerService.getAll();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/active")
    public ResponseEntity<List<ListIndCustomerResponseDto>> getAllActiveCustomers() {
        List<ListIndCustomerResponseDto> activeCustomers = individualCustomerService.findAllByDeletedDateIsNull();
        return ResponseEntity.ok(activeCustomers);
    }

    @GetMapping("/search")
    public List<IndividualCustomer> getByFirstNameOrLastNameOrMiddleNameOrderById
            (@RequestParam String firstName, @RequestParam String lastName) {
        return individualCustomerService.findByFirstNameAndLastName(firstName, lastName);
    }

}
