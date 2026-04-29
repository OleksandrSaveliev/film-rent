package com.my.filmrent.dto;

import com.my.filmrent.entity.enums.Rating;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class FilmResponseDto {

    private Integer filmId;
    private String title;
    private String description;
    private Short releaseYear;
    private Short rentalDuration;
    private BigDecimal rentalRate;
    private Short length;
    private BigDecimal replacementCost;
    private Rating rating;
    private String specialFeatures;
    private Integer languageId;
}
