package com.kata.bowling;

import java.util.Objects;

public class Score {

    public static final String NOT_ALLOWED_MINUS = "not allowed minus";
    public static final String NOT_ALLOWED_EXCEED_MAX_VALUE = "not allowed exceed max value";
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 300;

    private final int value;

    public Score(int value) {
        this.value = value;
    }

    public static Score of(int value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException(NOT_ALLOWED_MINUS);
        }
        if (value > MAX_VALUE) {
            throw new IllegalArgumentException(NOT_ALLOWED_EXCEED_MAX_VALUE);
        }
        return new Score(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return value == score.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
