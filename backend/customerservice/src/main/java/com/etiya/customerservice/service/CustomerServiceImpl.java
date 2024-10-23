package com.etiya.customerservice.service;

import com.etiya.customerservice.dto.request.CreateIndCustomerRequestDto;
import com.etiya.customerservice.dto.request.DeleteIndCustomerRequestDto;
import com.etiya.customerservice.dto.request.UpdateIndCustomerRequestDto;
import com.etiya.customerservice.dto.response.CreateIndCustomerResponseDto;
import com.etiya.customerservice.dto.response.DeleteIndCustomerResponseDto;
import com.etiya.customerservice.dto.response.ListIndCustomerResponseDto;
import com.etiya.customerservice.dto.response.UpdateIndCustomerResponseDto;
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
    public List<ListIndCustomerResponseDto> getAll() {
        return null;
    }

    @Transactional
    @Override
    public DeleteIndCustomerResponseDto delete(DeleteIndCustomerRequestDto deleteIndCustomerRequestDto) {
        return null;
    }

    @Transactional
    @Override
    public CreateIndCustomerResponseDto add(CreateIndCustomerRequestDto createIndCustomerRequestDto) {
        return null;
    }

    @Transactional
    @Override
    public UpdateIndCustomerResponseDto update(UpdateIndCustomerRequestDto updateIndCustomerRequestDto) {
        return null;
    }
}
