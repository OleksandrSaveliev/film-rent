package com.my.filmrent.entity.enums;

import lombok.Getter;

@Getter
public enum Rating {
    G("G"),
    PG("PG"),
    PG_13("PG-13"),
    R("R"),
    NC_17("NC-17");

    private final String dbValue;

    Rating(String dbValue) { this.dbValue = dbValue; }

    public static Rating fromDbValue(String value) {
        for (Rating r : values()) {
            if (r.dbValue.equals(value)) return r;
        }
        throw new IllegalArgumentException("Unknown rating: " + value);
    }
}
