package com.etiya.customerservice.service.CustomerService.IndividualCustomer;

import com.etiya.customerservice.dto.IndividualCustomer.request.CreateIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.DeleteIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.ListIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.UpdateIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.CreateIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.DeleteIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.ListIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.UpdateIndCustomerResponseDto;
import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.mapper.IndividualCustomerMapper;
import com.etiya.customerservice.repository.CustomerRepository.IndividualCustomerRepository;
import com.etiya.customerservice.rule.CustomerBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
        customerBusinessRules.customerWithSameNationalityId(createIndCustomerRequestDto.getNationalityId());

        IndividualCustomer individualCustomer = individualCustomerMapper.IndCustomerFromCreateRequest(createIndCustomerRequestDto);
        IndividualCustomer savedCustomer = individualCustomerRepository.save(individualCustomer);
        return individualCustomerMapper.IndCustomerCreateResponseFromCustomer(savedCustomer);
    }

    @Transactional
    @Override
    public UpdateIndCustomerResponseDto update(UpdateIndCustomerRequestDto updateIndCustomerRequestDto) {
        customerBusinessRules.checkIfCustomerExists(updateIndCustomerRequestDto.getCustomerId());
        IndividualCustomer existingCustomer = individualCustomerRepository.getCustomerById(updateIndCustomerRequestDto.getCustomerId());
        customerBusinessRules.customerWithSameNationalityId(updateIndCustomerRequestDto.getNationalityId());

        individualCustomerMapper.IndCustomerFromUpdateRequest(updateIndCustomerRequestDto, existingCustomer);
        IndividualCustomer updatedCustomer = individualCustomerRepository.save(existingCustomer);
        return individualCustomerMapper.IndCustomerUpdateResponseFromCustomer(updatedCustomer);
    }

    @Transactional
    @Override
    public DeleteIndCustomerResponseDto delete(DeleteIndCustomerRequestDto deleteIndCustomerRequestDto) {
        customerBusinessRules.checkIfCustomerExists(deleteIndCustomerRequestDto.getCustomerId());
        customerBusinessRules.checkIfCustomerIsActive(deleteIndCustomerRequestDto.getCustomerId());
        customerBusinessRules.checkIfCustomerHasCustomerAccount(deleteIndCustomerRequestDto.getCustomerId());

        IndividualCustomer individualCustomer = individualCustomerRepository.getCustomerById(deleteIndCustomerRequestDto.getCustomerId());
        individualCustomerRepository.delete(individualCustomer);
        return individualCustomerMapper.IndCustomerDeleteResponseFromCustomer(individualCustomer);
    }

    @Override
    public ListIndCustomerResponseDto getById(ListIndCustomerRequestDto listIndCustomerRequestDto) {
        customerBusinessRules.checkIfCustomerExists(listIndCustomerRequestDto.getCustomerId());
        IndividualCustomer customer = individualCustomerMapper.IndCustomerFromListRequest(listIndCustomerRequestDto);
        return individualCustomerMapper.IndCustomerResponseFromCustomer(customer);
    }

    @Override
    public IndividualCustomer getCustomerById(Integer id) {
        customerBusinessRules.checkIfCustomerExists(id);
        IndividualCustomer individualCustomer = individualCustomerRepository.getCustomerById(id);
        return individualCustomer;
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
}
