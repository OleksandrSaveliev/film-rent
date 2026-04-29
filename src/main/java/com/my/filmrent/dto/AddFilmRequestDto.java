package com.my.filmrent.dto;

import com.my.filmrent.entity.enums.Rating;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class AddFilmRequestDto {

    private String title;
    private String description;
    private Short releaseYear;
    private Integer languageId;
    private Short rentalDuration;
    private BigDecimal rentalRate;
    private Short length;
    private BigDecimal replacementCost;
    private Rating rating;
    private String specialFeatures;

    private String filmTextTitle;
    private String filmTextDescription;

    private Set<Integer> actorIds;
    private Set<Integer> categoryIds;

    private Set<Integer> storeIds;
}
