package com.etiya.customerservice.service.CustomerService.IndividualCustomer;

import com.etiya.customerservice.dto.IndividualCustomer.request.CreateIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.DeleteIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.UpdateIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.*;
import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.mapper.IndividualCustomerMapper;
import com.etiya.customerservice.repository.CustomerRepository.IndividualCustomerRepository;
import com.etiya.customerservice.rule.CustomerBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IndividualCustomerServiceImpl implements IndividualCustomerService {
    private final IndividualCustomerRepository individualCustomerRepository;
    private final IndividualCustomerMapper individualCustomerMapper;
    private final CustomerBusinessRules customerBusinessRules;


    @Transactional
    @Override
    public CreateIndCustomerResponseDto add(CreateIndCustomerRequestDto createIndCustomerRequestDto) {
        //Nationality ID check
        customerBusinessRules.customerWithSameNationalityId(createIndCustomerRequestDto.getNationalityId());
        customerBusinessRules.validateNationalityIdLength(createIndCustomerRequestDto.getNationalityId());
        customerBusinessRules.customerAgeMustBeAbove18(createIndCustomerRequestDto.getDateOfBirth().toLocalDate());

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
        //Nationality ID check
        customerBusinessRules.customerWithSameNationalityId(updateIndCustomerRequestDto.getNationalityId());
        individualCustomerMapper.IndCustomerFromUpdateRequest(updateIndCustomerRequestDto, existingCustomer);
        IndividualCustomer updatedCustomer = individualCustomerRepository.save(existingCustomer);

        return individualCustomerMapper.IndCustomerUpdateResponseFromCustomer(updatedCustomer);
    }

    @Transactional
    @Override
    public DeleteIndCustomerResponseDto delete(DeleteIndCustomerRequestDto deleteIndCustomerRequestDto) {
        IndividualCustomer individualCustomer = individualCustomerRepository.findById(deleteIndCustomerRequestDto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customerBusinessRules.checkIfCustomerIsActive(individualCustomer.getId());

        IndividualCustomer individualCustomer = individualCustomerRepository.getCustomerById(deleteIndCustomerRequestDto.getCustomerId());
        // individualCustomerRepository.delete(individualCustomer);
        individualCustomer.setDeletedDate(LocalDateTime.now());
        individualCustomerRepository.save(individualCustomer);
        return individualCustomerMapper.IndCustomerDeleteResponseFromCustomer(individualCustomer);
    }

    @Override
    public CustomerResponseDto getById(ListIndCustomerRequestDto listIndCustomerRequestDto) {
        customerBusinessRules.checkIfCustomerExists(listIndCustomerRequestDto.getCustomerId());
        IndividualCustomer customer = individualCustomerMapper.IndCustomerFromListRequest(listIndCustomerRequestDto);
        IndividualCustomer individualCustomers = individualCustomerRepository.getReferenceById(customer.getId());
        return individualCustomerMapper.IndCustomerResponseFromCustomerId(individualCustomers);
    }

        return Optional.ofNullable(individualCustomer);
    }

    @Override
    public List<ListIndCustomerResponseDto> getAll() {
        List<IndividualCustomer> individualCustomers = individualCustomerRepository.findAll();

        return individualCustomers.stream()
                .map(individualCustomerMapper::IndCustomerResponseFromCustomer)
                .collect(Collectors.toList());
    }

    @Override
    public List<IndividualCustomer> findByFirstNameAndLastName(String firstName, String lastName) {
        return individualCustomerRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<ListIndCustomerResponseDto> findAllByDeletedDateIsNull() {
        List<IndividualCustomer> individualCustomers = individualCustomerRepository.findAllByDeletedDateIsNull();
        return individualCustomers.stream()
                .map(individualCustomerMapper::IndCustomerResponseFromCustomer)
                .collect(Collectors.toList());
    }
}
