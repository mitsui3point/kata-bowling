package com.kata.bowling;

import java.util.Objects;

public class Pin {

    private final PinCount stand;
    private final PinCount down;

    public Pin(PinCount stand) {
        this.stand = stand;
        this.down = stand.rest();
    }

    public static Pin of(PinCount stand) {
        return new Pin(stand);
    }

    public Pin breakDown(PinCount pinCount) {
        return new Pin(this.stand.minus(pinCount));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pin pin = (Pin) o;
        return Objects.equals(stand, pin.stand) && Objects.equals(down, pin.down);
    }
    @Override
    public int hashCode() {
        return Objects.hash(stand, down);
    }

}
