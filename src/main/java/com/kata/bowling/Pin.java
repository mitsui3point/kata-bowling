package com.kata.bowling;

import java.util.Objects;

public class Pin {
    public static final String EXCEED_PIN_COUNT = "exceed pin";
    public static final String BELOW_PIN_COUNT = "below pin";
    public static final int MAX_VALUE = 10;
    public static final int MIN_VALUE = 0;
    static final String NOT_ALLOWED_EXCEED_REST_PIN = "not allowed exceed rest pin";
    private final int stand;
    private final int fallen;

    private Pin(int stand) {
        this.stand = stand;
        this.fallen = MAX_VALUE - stand;
    }

    public static Pin of(int rest) {
        if (rest > MAX_VALUE) {
            throw new IllegalArgumentException(EXCEED_PIN_COUNT);
        }
        if (rest < MIN_VALUE) {
            throw new IllegalArgumentException(BELOW_PIN_COUNT);
        }
        return new Pin(rest);
    }

    public static Pin of() {
        return new Pin(MAX_VALUE);
    }

    public Pin breakDown(int breakDownValue) {
        Pin breakDown = Pin.of(breakDownValue);
        if (this.stand < breakDown.stand) {
            throw new IllegalArgumentException(NOT_ALLOWED_EXCEED_REST_PIN);
        }

        return new Pin(this.stand - breakDown.stand);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pin pin = (Pin) o;
        return stand == pin.stand && fallen == pin.fallen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stand, fallen);
    }
}
