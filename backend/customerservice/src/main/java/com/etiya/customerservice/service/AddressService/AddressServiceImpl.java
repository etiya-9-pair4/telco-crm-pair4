package com.etiya.customerservice.service.AddressService;

import com.etiya.customerservice.dto.Address.request.CreateAddressRequestDto;
import com.etiya.customerservice.dto.Address.request.DeleteAddressRequestDto;
import com.etiya.customerservice.dto.Address.request.UpdateAddressRequestDto;
import com.etiya.customerservice.dto.Address.response.*;
import com.etiya.customerservice.dto.IndividualCustomer.response.ListIndCustomerResponseDto;
import com.etiya.customerservice.entity.Address;
import com.etiya.customerservice.entity.Contact;
import com.etiya.customerservice.entity.Customer;
import com.etiya.customerservice.mapper.AddressMapper;
import com.etiya.customerservice.repository.AddressRepository.AddressRepository;
import com.etiya.customerservice.repository.CustomerRepository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    //TODO: Business Exception EKLE!!!!!!!

    @Transactional
    @Override
    public CreateAddressResponseDto add(CreateAddressRequestDto createAddressRequestDto) {
        Address address = addressMapper.addressFromCreateRequest(createAddressRequestDto);
        addressRepository.save(address);
        return addressMapper.addressCreateResponseFromAddress(address);
    }

    @Transactional
    @Override
    public UpdateAddressResponseDto update(UpdateAddressRequestDto updateAddressRequestDto) {
        Address existingAddress = addressRepository.findById(updateAddressRequestDto.getAddressId())
                .orElseThrow(() -> new RuntimeException("Address not found"));

        Address updatedAddress = addressMapper.updateAddressFromRequest(updateAddressRequestDto, existingAddress);
        addressRepository.save(updatedAddress);
        return addressMapper.addressUpdateResponseFromAddress(updatedAddress);

    }

    @Transactional
    @Override
    public DeleteAddressResponseDto delete(DeleteAddressRequestDto deleteAddressRequestDto) {
        Address address = addressRepository.findById(deleteAddressRequestDto.getAddressId())
                .orElseThrow(() -> new RuntimeException("Address not found"));
        addressRepository.delete(address);
        return addressMapper.addressDeleteResponseFromAddress(address);
    }

    @Override
    public Optional<ListAddressResponseDto> getById(Integer id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
        ListAddressResponseDto addressResponseDto = addressMapper.addressResponseFromListAddress(address);
        return Optional.of(addressResponseDto);
    }

    @Override
    public List<ListAddressResponseDto> getAll() {
        List<Address> addresses = addressRepository.findAll();
        List<ListAddressResponseDto> responseDtos = addressMapper.addressResponseFromListAddress(addresses);
        return responseDtos;
    }

    @Override
    public List<ListAddressByCustomerIdResponseDto> findByCustomerId(Integer customerId) {
        List<Address> addresses = addressRepository.findByCustomerId(customerId);
        return addresses.stream()
                .map(addressMapper::addressResponseFromListAddressByCustomerId)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ListAddressByCustomerIdResponseDto> findByCustomerIdAndIsDefaultTrue(Integer customerId) {
        Optional<Address> addressOptional = addressRepository.findByCustomerIdAndIsDefaultTrue(customerId);
        return addressOptional.map(addressMapper::addressResponseFromListAddressByCustomerId);
    }

}
