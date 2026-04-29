package com.my.filmrent.controller;

import com.my.filmrent.dto.CreateCustomerRequestDto;
import com.my.filmrent.dto.CustomerResponseDto;
import com.my.filmrent.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponseDto> createCustomer(
            @RequestBody CreateCustomerRequestDto requestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customerService.createCustomer(requestDto));
    }
}
