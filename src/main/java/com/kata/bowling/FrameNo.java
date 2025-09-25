package com.kata.bowling;

import java.util.Objects;

public class FrameNo {
    public static final String EXCEED_FRAME_NO = "exceed frame no";
    public static final String BELOW_FRAME_NO = "below frame no";
    private static final int MIN = 0;
    private static final int MAX = 10;

    private final int value;

    private FrameNo(int value) {
        this.value = value;
    }

    public static FrameNo of(int value) {
        if (MIN > value) {
            throw new IllegalArgumentException(BELOW_FRAME_NO);
        }
        if (MAX < value) {
            throw new IllegalArgumentException(EXCEED_FRAME_NO);
        }
        return new FrameNo(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrameNo frameNo = (FrameNo) o;
        return value == frameNo.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
