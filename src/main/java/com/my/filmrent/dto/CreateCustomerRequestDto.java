package com.my.filmrent.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class CreateCustomerRequestDto {

    private String firstName;
    private String lastName;
    private String email;

    private String address;
    private String address2;
    private String district;
    private String postalCode;
    private String phone;

    private Integer cityId;
    private Integer storeId;
}
