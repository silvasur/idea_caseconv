package me.laria.code.idea_caseconv;

import java.util.HashMap;
import java.util.Map;

public enum ConversionType {
    CAMEL(0),
    DASH(1),
    DOT(2),
    FLIP(3),
    LOWER(4),
    PASCAL(5),
    SCREAMING_SNAKE(6),
    SENTENCE(7),
    SEPARATE_WORDS(8),
    SNAKE(9),
    TITLE(10),
    UPPER(11),
    ;


    private static final Map<Integer, ConversionType> BY_VALUE = new HashMap<>();

    static {
        for (ConversionType e : values()) {
            BY_VALUE.put(e.value, e);
        }
    }

    private final int value;

    ConversionType(int value) {
        this.value = value;
    }

    public static ConversionType fromValue(int value) {
        return BY_VALUE.get(value);
    }

    private int toValue() {
        return value;
    }
}

