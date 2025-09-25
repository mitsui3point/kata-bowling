package com.kata.bowling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.kata.bowling.PinCount.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PinCountTest {

    @Test
    void create() {
        PinCount actual = PinCount.of(1);
        PinCount expected = PinCount.of(1);

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void create_default() {
        PinCount actual = PinCount.of();
        PinCount expected = PinCount.of(10);

        assertThat(actual).isEqualTo(expected);
    }

    // 범위 제한
    @Test
    void create_fail_range() {
        assertThatThrownBy(() -> PinCount.of(11))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEED_PIN_COUNT);
        assertThatThrownBy(() -> PinCount.of(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BELOW_PIN_COUNT);
    }

    // minus
    @ParameterizedTest
    @CsvSource(value = {
            "1, 9", "2, 8", "3, 7", "4, 6",
            "5, 5",
            "6, 4", "7, 3", "8, 2", "9, 1",
    })
    void minus(int minus, int result) {
        PinCount actual = PinCount.of().minus(PinCount.of(minus));
        PinCount expected = PinCount.of(result);

        assertThat(actual).isEqualTo(expected);
    }
}