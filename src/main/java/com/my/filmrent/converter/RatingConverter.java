package com.my.filmrent.converter;

import com.my.filmrent.entity.enums.Rating;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RatingConverter implements AttributeConverter<Rating, String> {

    @Override
    public String convertToDatabaseColumn(Rating rating) {
        if (rating == null) return null;
        return rating.getDbValue();
    }

    @Override
    public Rating convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        return Rating.fromDbValue(dbData);
    }
}
