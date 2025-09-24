package com.kata.bowling;

import org.junit.jupiter.api.Test;

import static com.kata.bowling.PinCount.BELOW_PIN_COUNT;
import static com.kata.bowling.PinCount.EXCEED_PIN_COUNT;
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
        assertThatThrownBy(() -> PinCount.of(22))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEED_PIN_COUNT);
        assertThatThrownBy(() -> PinCount.of(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BELOW_PIN_COUNT);
    }
}