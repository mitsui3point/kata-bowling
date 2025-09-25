package com.kata.bowling;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PinTest {

    public static final PinCount PIN_COUNT = PinCount.of();

    @Test
    void create() {
        Pin actual = Pin.of(PIN_COUNT);
        Pin expected = Pin.of(PinCount.of(10));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void breakDown() {
        Pin pin = Pin.of(PIN_COUNT);

        Pin actual = pin.breakDown(PinCount.of(8));
        Pin expected = Pin.of(PinCount.of(2));

        assertThat(actual).isEqualTo(expected);
    }
}
