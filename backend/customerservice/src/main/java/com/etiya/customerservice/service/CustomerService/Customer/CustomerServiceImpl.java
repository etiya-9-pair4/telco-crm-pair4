package com.etiya.customerservice.service.CustomerService.Customer;

import com.etiya.customerservice.dto.Customer.request.CreateCustomerRequestDto;
import com.etiya.customerservice.dto.Customer.request.DeleteCustomerRequestDto;
import com.etiya.customerservice.dto.Customer.request.UpdateCustomerRequestDto;
import com.etiya.customerservice.dto.Customer.response.*;
import com.etiya.customerservice.entity.Customer;
import com.etiya.customerservice.mapper.CustomerMapper;
import com.etiya.customerservice.repository.CustomerRepository.CustomerRepository;
import com.etiya.customerservice.rule.CustomerBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository<Customer> customerRepository;
    private final CustomerMapper customerMapper;

    @Transactional
    @Override
    public CreateCustomerResponseDto add(CreateCustomerRequestDto request) {
        Customer customer = customerMapper.toCustomer(request);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toCreateCustomerResponseDto(savedCustomer);
    }

    @Transactional
    @Override
    public UpdateCustomerResponseDto update(UpdateCustomerRequestDto request) {
        Customer existingCustomer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Customer updatedCustomer = customerMapper.updateCustomerFromRequest(request, existingCustomer);
        customerRepository.save(updatedCustomer);
        return customerMapper.toUpdateCustomerResponseDto(updatedCustomer);
    }

    @Transactional
    @Override
    public DeleteCustomerResponseDto delete(DeleteCustomerRequestDto request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customerRepository.delete(customer);
        return new DeleteCustomerResponseDto(request.getCustomerId(), customer.getDeletedDate());
    }

    @Override
    public Optional<CustomerResponseDto> getById(Integer id) {
        return customerRepository.findById(id)
                .map(customerMapper::toCustomerResponseDto);
    }

    @Override
    public List<CustomerResponseDto> getAll() {
        return customerRepository.findAll().stream()
                .map(customerMapper::toCustomerResponseDto)
                .collect(Collectors.toList());
    }

}
