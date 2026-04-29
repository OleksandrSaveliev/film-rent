package com.my.filmrent.service;

import com.my.filmrent.dto.RentInventoryRequestDto;
import com.my.filmrent.dto.RentalResponseDto;
import com.my.filmrent.dto.ReturnRentalRequestDto;

public interface RentalService {

    RentalResponseDto returnFilm(ReturnRentalRequestDto requestDto);

    RentalResponseDto rentInventory(RentInventoryRequestDto requestDto);
}
