package com.my.filmrent.service.impl;

import com.my.filmrent.dto.CreateCustomerRequestDto;
import com.my.filmrent.dto.CustomerResponseDto;
import com.my.filmrent.entity.Address;
import com.my.filmrent.entity.City;
import com.my.filmrent.entity.Customer;
import com.my.filmrent.entity.Store;
import com.my.filmrent.repository.AddressRepository;
import com.my.filmrent.repository.CityRepository;
import com.my.filmrent.repository.CustomerRepository;
import com.my.filmrent.repository.StoreRepository;
import com.my.filmrent.service.CustomerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final CityRepository cityRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public CustomerResponseDto createCustomer(CreateCustomerRequestDto dto) {
        City city = cityRepository.findById(dto.getCityId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "City not found: " + dto.getCityId()));

        Store store = storeRepository.findById(dto.getStoreId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Store not found: " + dto.getStoreId()));

        Address address = new Address();
        address.setAddress(dto.getAddress());
        address.setAddress2(dto.getAddress2());
        address.setDistrict(dto.getDistrict());
        address.setPostalCode(dto.getPostalCode());
        address.setPhone(dto.getPhone());
        address.setCity(city);
        addressRepository.save(address);

        Customer customer = new Customer();
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        customer.setAddress(address);
        customer.setStore(store);
        customer.setActive(true);
        customer.setCreateDate(LocalDateTime.now());
        customerRepository.save(customer);

        return toResponseDto(customer);
    }

    private CustomerResponseDto toResponseDto(Customer customer) {
        CustomerResponseDto dto = new CustomerResponseDto();
        dto.setCustomerId(customer.getCustomerId());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setEmail(customer.getEmail());
        dto.setActive(customer.isActive());
        dto.setAddressId(customer.getAddress().getAddressId());
        dto.setStoreId(customer.getStore().getStoreId());
        return dto;
    }
}
