package com.kata.bowling;

import java.util.Objects;

public class PinCount {
    public static final String EXCEED_PIN_COUNT = "exceed pin count";
    public static final String BELOW_PIN_COUNT = "below pin count";
    public static final String EXCEED_REST_PIN_COUNT = "exceed rest pin count";
    public static final String NOT_ALLOWED_MINUS_BREAKDOWN_PARAMETER = "not allowed minus breakdown parameter";
    public static final int MAX_VALUE = 10;
    public static final int MIN_VALUE = 0;
    private final int stand;
    private final int rest;

    private PinCount(int stand) {
        this.stand = stand;
        this.rest = MAX_VALUE - stand;
    }

    public static PinCount of(int count) {
        if (count > MAX_VALUE) {
            throw new IllegalArgumentException(EXCEED_PIN_COUNT);
        }
        if (count < MIN_VALUE) {
            throw new IllegalArgumentException(BELOW_PIN_COUNT);
        }
        return new PinCount(count);
    }

    public static PinCount of() {
        return new PinCount(MAX_VALUE);
    }

    public PinCount minus(PinCount down) {
        if (this.stand < down.stand) {
            throw new IllegalArgumentException(EXCEED_REST_PIN_COUNT);
        }
        if (down.stand < 0) {
            throw new IllegalArgumentException(NOT_ALLOWED_MINUS_BREAKDOWN_PARAMETER);
        }

        return new PinCount(this.stand - down.stand);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PinCount pinCount = (PinCount) o;
        return stand == pinCount.stand && rest == pinCount.rest;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stand, rest);
    }
}
