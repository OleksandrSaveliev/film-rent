package com.my.filmrent.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class ReturnRentalRequestDto {

    private Integer customerId;
    private Integer rentalId;
}
