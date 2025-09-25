package com.kata.bowling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.kata.bowling.Pin.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PinTest {

    @Test
    void create() {
        Pin actual = Pin.of(1);
        Pin expected = Pin.of(1);

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void create_default() {
        Pin actual = Pin.of();
        Pin expected = Pin.of(10);

        assertThat(actual).isEqualTo(expected);
    }

    // 범위 제한
    @Test
    void create_fail_range() {
        assertThatThrownBy(() -> Pin.of(11))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEED_PIN_COUNT);
        assertThatThrownBy(() -> Pin.of(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BELOW_PIN_COUNT);
    }

    // breakDown
    @ParameterizedTest
    @CsvSource(value = {
            "1, 9", "2, 8", "3, 7", "4, 6",
            "5, 5",
            "6, 4", "7, 3", "8, 2", "9, 1",
    })
    void breakDown(int minus, int result) {
        Pin actual = Pin.of().breakDown(minus);
        Pin expected = Pin.of(result);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void breakDown_fail_range() {
        assertThatThrownBy(() -> Pin.of(8).breakDown(9))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ALLOWED_EXCEED_REST_PIN);
        assertThatThrownBy(() -> Pin.of().breakDown(11))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEED_PIN_COUNT);
        assertThatThrownBy(() -> Pin.of().breakDown(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BELOW_PIN_COUNT);
    }
}