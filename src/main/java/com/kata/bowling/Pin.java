package com.kata.bowling;

import java.util.Objects;

public class Pin {

    private final PinCount pinCount;

    public Pin(PinCount pinCount) {
        this.pinCount = pinCount;
    }

    public static Pin of(int stand) {
        return new Pin(PinCount.of(stand));
    }

    public Pin breakDown(int breakDown) {
        PinCount breakDownPin = PinCount.of(breakDown);
        return new Pin(this.pinCount.minus(breakDownPin));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pin pin = (Pin) o;
        return Objects.equals(pinCount, pin.pinCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pinCount);
    }
}
