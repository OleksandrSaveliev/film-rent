package com.my.filmrent.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class CustomerResponseDto {

    private Integer customerId;
    private String firstName;
    private String lastName;
    private String email;
    private boolean active;
    private Integer addressId;
    private Integer storeId;
}
