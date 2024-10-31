package com.etiya.customerservice.service.CustomerService.IndividualCustomer;

import com.etiya.customerservice.dto.Customer.request.CreateCustomerRequestDto;
import com.etiya.customerservice.dto.Customer.response.CreateCustomerResponseDto;
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
import com.etiya.customerservice.mapper.IndividualCustomerMapper;
import com.etiya.customerservice.repository.CustomerRepository.CustomerRepository;
import com.etiya.customerservice.repository.CustomerRepository.IndividualCustomerRepository;
import com.etiya.customerservice.service.CustomerService.Customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IndividualCustomerServiceImpl implements IndividualCustomerService {
    private final IndividualCustomerRepository individualCustomerRepository;
    private final IndividualCustomerMapper individualCustomerMapper;



    @Transactional
    @Override
    public CreateIndCustomerResponseDto add(CreateIndCustomerRequestDto createIndCustomerRequestDto) {
//        businessRules.checkIfNationalityIdExists(createIndCustomerRequestDto.getNationalityId());

        IndividualCustomer individualCustomer = individualCustomerMapper
                .IndCustomerFromCreateRequest(createIndCustomerRequestDto);

        IndividualCustomer savedCustomer = individualCustomerRepository.save(individualCustomer);

        return individualCustomerMapper.IndCustomerCreateResponseFromCustomer(savedCustomer);
    }

    @Transactional
    @Override
    public UpdateIndCustomerResponseDto update(UpdateIndCustomerRequestDto updateIndCustomerRequestDto) {
        IndividualCustomer existingCustomer = individualCustomerRepository.findById(updateIndCustomerRequestDto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        individualCustomerMapper.IndCustomerFromUpdateRequest(updateIndCustomerRequestDto, existingCustomer);
        IndividualCustomer updatedCustomer = individualCustomerRepository.save(existingCustomer);

        return individualCustomerMapper.IndCustomerUpdateResponseFromCustomer(updatedCustomer);
    }

    @Transactional
    @Override
    public DeleteIndCustomerResponseDto delete(DeleteIndCustomerRequestDto deleteIndCustomerRequestDto) {
        IndividualCustomer individualCustomer = individualCustomerRepository.findById(deleteIndCustomerRequestDto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        individualCustomerRepository.delete(individualCustomer);

        return individualCustomerMapper.IndCustomerDeleteResponseFromCustomer(individualCustomer);
    }

    @Override
    public Optional<Customer> getCustomerById(Integer id) {
        IndividualCustomer individualCustomer = individualCustomerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return Optional.ofNullable(individualCustomer);
    }

    @Override
    public List<ListIndCustomerResponseDto> getAll() {
        List<IndividualCustomer> individualCustomers = individualCustomerRepository.findAll();

        return individualCustomers.stream()
                .map(individualCustomerMapper::IndCustomerResponseFromCustomer)
                .collect(Collectors.toList());
    }
}
