package com.my.filmrent.controller;

import com.my.filmrent.dto.request.CreateCustomerRequestDto;
import com.my.filmrent.dto.response.CustomerResponseDto;
import com.my.filmrent.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
