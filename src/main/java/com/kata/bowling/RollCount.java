package com.kata.bowling;

import java.util.Objects;

public class RollCount {

    public static final String EXCEED_ROLL_COUNT = "exceed roll count";
    public static final String BELOW_ROLL_COUNT = "below roll count";
    private static final int MAX = 21;
    private static final int MIN = 0;
    private final int count;

    private RollCount(int count) {
        this.count = count;
    }

    public static RollCount of(int count) {
        if (count > MAX) {
            throw new IllegalArgumentException(EXCEED_ROLL_COUNT);
        }
        if (count < MIN) {
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
