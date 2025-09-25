package com.kata.bowling;

import java.util.Objects;

public class PinCount {
    public static final String EXCEED_PIN_COUNT = "exceed pin count";
    public static final String BELOW_PIN_COUNT = "below pin count";
    public static final String EXCEED_REST_PIN_COUNT = "exceed rest pin count";
    public static final String NOT_ALLOWED_MINUS_BREAKDOWN_PARAMETER = "not allowed minus breakdown parameter";
    public static final int DEFAULT_COUNT = 10;
    private final int count;

    private PinCount(int count) {
        this.count = count;
    }

    public static PinCount of(int count) {
        if (count > 10) {
            throw new IllegalArgumentException(EXCEED_PIN_COUNT);
        }
        if (count < 0) {
            throw new IllegalArgumentException(BELOW_PIN_COUNT);
        }
        return new PinCount(count);
    }

    public static PinCount of() {
        return new PinCount(DEFAULT_COUNT);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PinCount pinCount = (PinCount) o;
        return count == pinCount.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    public PinCount minus(PinCount down) {
        if (this.count < down.count) {
            throw new IllegalArgumentException(EXCEED_REST_PIN_COUNT);
        }
        if (down.count < 0) {
            throw new IllegalArgumentException(NOT_ALLOWED_MINUS_BREAKDOWN_PARAMETER);
        }

        return new PinCount(this.count - down.count);
    }

    public PinCount rest() {
        return new PinCount(DEFAULT_COUNT - this.count);
    }
}
