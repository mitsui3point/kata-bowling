package com.kata.bowling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.kata.bowling.Pin.NOT_ALLOW_BELOW_ZERO;
import static com.kata.bowling.Pin.NOT_ALLOW_EXCEED_TEN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PinTest {

    @Test
    void create() {
        Pin actual = new Pin();
        Pin expected = Pin.of(10);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void create_fail() {
        assertThatThrownBy(() -> Pin.of(11))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ALLOW_EXCEED_TEN);
        assertThatThrownBy(() -> Pin.of(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ALLOW_BELOW_ZERO);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0, 10", "1, 9", "2, 8", "3, 7", "4, 6",
            "5, 5",
            "6, 4", "7, 3", "8, 2", "9, 1", "10, 0"})
    void breakDown(int param, int result) {
        Pin pin = new Pin();
        Pin actual = pin.breakDown(param);
        Pin expected = Pin.of(result);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void breakDown_fail() {
        assertThatThrownBy(() -> new Pin().breakDown(11))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ALLOW_BELOW_ZERO);
        assertThatThrownBy(() -> new Pin().breakDown(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ALLOW_EXCEED_TEN);
    }
}
