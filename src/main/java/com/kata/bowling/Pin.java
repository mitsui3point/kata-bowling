package com.kata.bowling;

import java.util.Objects;

public class Pin {
    public static final String NOT_ALLOW_EXCEED_TEN = "Pin 은 11을 넘을수 없음";
    public static final String NOT_ALLOW_BELOW_ZERO = "Pin 은 0보다 작을수 없음";
    private static final int MAX = 10;
    private static final int MIN = 0;

    private final int stand;

    private Pin(int stand) {
        this.stand = stand;
    }

    public Pin() {
        this.stand = MAX;
    }

    public static Pin of(int stand) {
        if (stand > MAX) {
            throw new IllegalArgumentException(NOT_ALLOW_EXCEED_TEN);
        }
        if (stand < MIN) {
            throw new IllegalArgumentException(NOT_ALLOW_BELOW_ZERO);
        }
        return new Pin(stand);
    }

    public Pin breakDown(int stand) {
        return Pin.of(this.stand - stand);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pin pin = (Pin) o;
        return stand == pin.stand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stand);
    }
}
