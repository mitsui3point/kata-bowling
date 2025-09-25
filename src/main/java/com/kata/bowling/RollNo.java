package com.kata.bowling;

import java.util.Objects;

public class RollNo {

    public static final String EXCEED_ROLL_NO = "exceed roll count";
    public static final String BELOW_ROLL_NO = "below roll count";
    private static final int MAX = 21;
    private static final int MIN = 0;
    private final int value;

    private RollNo(int value) {
        this.value = value;
    }

    public static RollNo of(int count) {
        if (count > MAX) {
            throw new IllegalArgumentException(EXCEED_ROLL_NO);
        }
        if (count < MIN) {
            throw new IllegalArgumentException(BELOW_ROLL_NO);
        }
        return new RollNo(count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RollNo rollNo = (RollNo) o;
        return value == rollNo.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
