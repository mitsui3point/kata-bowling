package com.kata.bowling;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PinTest {

    @Test
    void create() {
        Pin actual = Pin.of(10);
        Pin expected = Pin.of(10);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void breakDown() {
        Pin actual = Pin.of(10).breakDown(8);
        Pin expected = Pin.of(2);

        assertThat(actual).isEqualTo(expected);
    }
}
