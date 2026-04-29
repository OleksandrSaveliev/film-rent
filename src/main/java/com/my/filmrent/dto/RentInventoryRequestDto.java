package com.my.filmrent.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class RentInventoryRequestDto {

    private Integer customerId;
    private Integer inventoryId;
    private Integer staffId;
    private BigDecimal paymentAmount;
}
