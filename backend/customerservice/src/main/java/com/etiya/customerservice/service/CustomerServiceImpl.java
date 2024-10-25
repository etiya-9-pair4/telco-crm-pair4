package com.etiya.customerservice.service;

import com.etiya.customerservice.dto.IndividualCustomer.request.CreateIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.DeleteIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.UpdateIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.CreateIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.DeleteIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.ListIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.UpdateIndCustomerResponseDto;
import com.etiya.customerservice.entity.Customer;
import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.mapper.CustomerMapper;
import com.etiya.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository<IndividualCustomer> IndividualCustomerRepository;
    private final CustomerRepository<Customer> customerRepository;
    private final CustomerMapper customerMapper;


    //TODO: Business Exception EKLE!!!!!!!
    @Transactional
    @Override
    public CreateIndCustomerResponseDto add(CreateIndCustomerRequestDto createIndCustomerRequestDto) {
//        individualCustomerBusinessRules.indCustomerWithSameDetailsShouldNotExist(createIndCustomerRequestDto);

        IndividualCustomer individualCustomer = customerMapper.IndCustomerFromCreateRequest(createIndCustomerRequestDto);
        IndividualCustomerRepository.save(individualCustomer);
        return customerMapper.IndCustomerCreateResponseFromCustomer(individualCustomer);
    }
    @Transactional
    @Override
    public UpdateIndCustomerResponseDto update(UpdateIndCustomerRequestDto updateIndCustomerRequestDto) {
        IndividualCustomer existingCustomer = IndividualCustomerRepository.findById(updateIndCustomerRequestDto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        IndividualCustomer updatedCustomer = customerMapper.IndCustomerFromUpdateRequest(updateIndCustomerRequestDto);
        updatedCustomer.setId(existingCustomer.getId());
        IndividualCustomerRepository.save(updatedCustomer);

        return customerMapper.IndCustomerUpdateResponseFromCustomer(updatedCustomer);
    }


    @Transactional
    @Override
    public DeleteIndCustomerResponseDto delete(DeleteIndCustomerRequestDto deleteIndCustomerRequestDto) {
        IndividualCustomer individualCustomer = IndividualCustomerRepository.findById(deleteIndCustomerRequestDto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        IndividualCustomerRepository.delete(individualCustomer);

        return customerMapper.IndCustomerDeleteResponseFromCustomer(individualCustomer);
    }

    @Override
    public Optional<Customer> getCustomerById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<ListIndCustomerResponseDto> getAll() {
        List<IndividualCustomer> individualCustomers = IndividualCustomerRepository.findAll();

        return individualCustomers.stream()
                .map(customerMapper::IndCustomerResponseFromListCustomer)
                .collect(Collectors.toList());
    }
}
