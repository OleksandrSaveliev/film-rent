package com.my.filmrent.service;

import com.my.filmrent.dto.CreateCustomerRequestDto;
import com.my.filmrent.dto.CustomerResponseDto;

public interface CustomerService {

    CustomerResponseDto createCustomer(CreateCustomerRequestDto requestDto);
}
