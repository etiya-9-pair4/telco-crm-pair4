package com.etiya.customerservice.service.CustomerAccountService;


import com.etiya.customerservice.dto.CustomerAccount.request.*;
import com.etiya.customerservice.dto.CustomerAccount.response.*;

import java.util.List;
import java.util.Optional;

public interface CustomerAccountService {
    CreateCustomerAccountResponseDto add(CreateCustomerAccountRequestDto requestDto);

    UpdateCustomerAccountResponseDto update(UpdateCustomerAccountRequestDto requestDto);

    DeleteCustomerAccountResponseDto delete(DeleteCustomerAccountRequestDto requestDto);

    Optional<ListCustomerAccountResponseDto> getById(ListCustomerAccountRequestDto requestDto);

    List<ListCustomerAccountResponseDto> getAll();


    List<ListCustomerAccountByCustomerIdResponseDto> findByCustomerId(Integer customerId);
}
