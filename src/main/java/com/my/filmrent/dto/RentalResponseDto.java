package com.my.filmrent.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class RentalResponseDto {

    private Integer rentalId;
    private Integer customerId;
    private Integer inventoryId;
    private Integer staffId;
    private LocalDateTime rentalDate;
    private LocalDateTime returnDate;
}
