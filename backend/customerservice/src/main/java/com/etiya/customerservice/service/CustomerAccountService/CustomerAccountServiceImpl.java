package com.etiya.customerservice.service.CustomerAccountService;

import com.etiya.customerservice.dto.CustomerAccount.request.*;
import com.etiya.customerservice.dto.CustomerAccount.response.*;
import com.etiya.customerservice.entity.CustomerAccount;
import com.etiya.customerservice.mapper.CustomerAccountMapper;
import com.etiya.customerservice.repository.CustomerAccountRepository.CustomerAccountRepository;
import com.etiya.customerservice.rule.CustomerBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerAccountServiceImpl implements CustomerAccountService {

    private final CustomerAccountRepository customerAccountRepository;
    private final CustomerAccountMapper customerAccountMapper;
    private final CustomerBusinessRules customerBusinessRules;

    @Transactional
    @Override
    public CreateCustomerAccountResponseDto add(CreateCustomerAccountRequestDto requestDto) {
        CustomerAccount customerAccount = customerAccountMapper.customerAccountFromCreateRequest(requestDto);

        //Business codes. -> Gözden geçirilmeli!
        customerAccount.setStatus(true);
//        if (requestDto.getAccountNumber() == null || requestDto.getAccountNumber().isEmpty()) {
//            int accNo=1000000000;
//            customerAccount.setAccountNumber(accNo);
//        } else {
//            customerAccount.setAccountNumber(requestDto.getAccountNumber());
//        }

        customerAccountRepository.save(customerAccount);
//
//        if ("00000000".equals(customerAccount.getAccountNumber())) {
//            customerAccount.setAccountNumber("00000000" + customerAccount.getId());
//            customerAccountRepository.save(customerAccount);
//        }
        return customerAccountMapper.customerAccountCreateResponseFromEntity(customerAccount);
    }

    @Transactional
    @Override
    public UpdateCustomerAccountResponseDto update(UpdateCustomerAccountRequestDto requestDto) {
        CustomerAccount existingAccount = customerAccountRepository.findById(requestDto.getId())
                .orElseThrow(() -> new RuntimeException("Customer account not found"));
        CustomerAccount updatedAccount = customerAccountMapper.customerAccountFromUpdateRequest(requestDto, existingAccount);
        customerAccountRepository.save(updatedAccount);
        return customerAccountMapper.customerAccountUpdateResponseFromEntity(updatedAccount);
    }

    @Transactional
    @Override
    public DeleteCustomerAccountResponseDto delete(DeleteCustomerAccountRequestDto requestDto) {
        CustomerAccount customerAccount = customerAccountRepository.findById(requestDto.getId())
                .orElseThrow(() -> new RuntimeException("Customer account not found"));

        customerAccount.setStatus(false);
        customerAccountRepository.delete(customerAccount);
        return customerAccountMapper.customerAccountDeleteResponseFromEntity(customerAccount);
    }

    @Override
    public Optional<ListCustomerAccountResponseDto> getById(ListCustomerAccountRequestDto requestDto) {
        CustomerAccount customerAccount = customerAccountRepository.findById(requestDto.getId())
                .orElseThrow(() -> new RuntimeException("Customer account not found"));
        ListCustomerAccountResponseDto responseDto = customerAccountMapper.customerAccountResponseFromList(customerAccount);
        return Optional.of(responseDto);
    }

    @Override
    public List<ListCustomerAccountResponseDto> getAll() {
        List<CustomerAccount> customerAccounts = customerAccountRepository.findAll();
        return customerAccountMapper.customerAccountResponseListFromCustomerAccount(customerAccounts);
    }

    @Override
    public List<ListCustomerAccountByCustomerIdResponseDto> findByCustomerId(Integer customerId) {
        List<CustomerAccount> customerAccounts = customerAccountRepository.findByCustomer_Id(customerId);
        return customerAccounts.stream()
                .map(customerAccountMapper::customerAccountResponseFromListByCustomerId)
                .collect(Collectors.toList());
    }
}
