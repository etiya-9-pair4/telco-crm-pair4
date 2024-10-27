package com.etiya.customerservice.service.AddressService;

import com.etiya.customerservice.dto.Address.request.CreateAddressRequestDto;
import com.etiya.customerservice.dto.Address.request.DeleteAddressRequestDto;
import com.etiya.customerservice.dto.Address.request.UpdateAddressRequestDto;
import com.etiya.customerservice.dto.Address.response.*;
import com.etiya.customerservice.dto.IndividualCustomer.request.CreateIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.DeleteIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.UpdateIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.CreateIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.DeleteIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.ListIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.UpdateIndCustomerResponseDto;
import com.etiya.customerservice.entity.Address;
import com.etiya.customerservice.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    CreateAddressResponseDto add(CreateAddressRequestDto createAddressRequestDto);
    UpdateAddressResponseDto update(UpdateAddressRequestDto updateAddressRequestDto);
    DeleteAddressResponseDto delete(DeleteAddressRequestDto deleteAddressRequestDto);

    Optional<ListAddressResponseDto> getAddressById(Integer id);
    List<ListAddressByCustomerIdResponseDto> getAllAddressesByCustomerId(Integer customerId);
    List<ListAddressResponseDto> findByCustomerId(Integer customerId);
    Optional<ListAddressResponseDto> findByCustomerIdAndIsDefaultTrue(Integer customerId);
}

