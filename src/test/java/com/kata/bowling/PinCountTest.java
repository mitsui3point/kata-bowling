package com.kata.bowling;

import org.junit.jupiter.api.Test;

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

    @Test
    void create_default() {
        PinCount actual = PinCount.of();
        PinCount expected = PinCount.of(10);

        assertThat(actual).isEqualTo(expected);
    }

    // breakDown
    @Test
    void breakDown() {
        PinCount actual = PinCount.of(10).breakDown(1);
        PinCount expected = PinCount.of(9);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void breakDown_fail_range() {
        assertThatThrownBy(() -> PinCount.of(10).breakDown(11))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEED_REST_PIN_COUNT);
        assertThatThrownBy(() -> PinCount.of(10).breakDown(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ALLOWED_MINUS_BREAKDOWN_PARAMETER);
    }

}