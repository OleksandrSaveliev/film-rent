package com.my.filmrent.controller;

import com.my.filmrent.dto.RentInventoryRequestDto;
import com.my.filmrent.dto.RentalResponseDto;
import com.my.filmrent.dto.ReturnRentalRequestDto;
import com.my.filmrent.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rentals")
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;

    @PostMapping
    public ResponseEntity<RentalResponseDto> rentInventory(
            @RequestBody RentInventoryRequestDto requestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(rentalService.rentInventory(requestDto));
    }

    @PatchMapping("/return")
    public ResponseEntity<RentalResponseDto> returnFilm(
            @RequestBody ReturnRentalRequestDto requestDto) {
        return ResponseEntity.ok(rentalService.returnFilm(requestDto));
    }
}
