package com.kata.bowling;

import java.util.Objects;

public class RollCount {

    public static final String EXCEED_ROLL_COUNT = "exceed roll count";
    public static final String BELOW_ROLL_COUNT = "below roll count";
    private final int count;

    private RollCount(int count) {
        this.count = count;
    }

    public static RollCount of(int count) {
        if (count > 21) {
            throw new IllegalArgumentException(EXCEED_ROLL_COUNT);
        }
        if (count < 0) {
            throw new IllegalArgumentException(BELOW_ROLL_COUNT);
        }
        return new RollCount(count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RollCount rollCount = (RollCount) o;
        return count == rollCount.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
