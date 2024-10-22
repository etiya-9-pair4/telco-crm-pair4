package com.etiya.customerservice.service;

import com.etiya.customerservice.dto.request.CreateCustomerRequestDto;
import com.etiya.customerservice.dto.request.DeleteCustomerRequestDto;
import com.etiya.customerservice.dto.request.UpdateCustomerRequestDto;
import com.etiya.customerservice.dto.response.CreateCustomerResponseDto;
import com.etiya.customerservice.dto.response.DeleteCustomerResponseDto;
import com.etiya.customerservice.dto.response.ListCustomerResponseDto;
import com.etiya.customerservice.dto.response.UpdateCustomerResponseDto;
import com.etiya.customerservice.entity.Customer;
import com.etiya.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Optional<Customer> getCustomerById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<ListCustomerResponseDto> getAll() {
        return null;
    }

    @Transactional
    @Override
    public DeleteCustomerResponseDto delete(DeleteCustomerRequestDto deleteCustomerRequestDto) {
        return null;
    }

    @Transactional
    @Override
    public CreateCustomerResponseDto add(CreateCustomerRequestDto createCustomerRequestDto) {
        return null;
    }

    @Transactional
    @Override
    public UpdateCustomerResponseDto update(UpdateCustomerRequestDto updateCustomerRequestDto) {
        return null;
    }
}
