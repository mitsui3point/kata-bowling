package com.kata.bowling;

import org.junit.jupiter.api.Test;

import static com.kata.bowling.RollCount.BELOW_ROLL_COUNT;
import static com.kata.bowling.RollCount.EXCEED_ROLL_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RollCountTest {
    @Test
    void create() {
        RollCount actual = RollCount.of(1);
        RollCount expected = RollCount.of(1);

        assertThat(actual).isEqualTo(expected);

    }

    // 범위 제한
    @Test
    void create_fail_range() {
        assertThatThrownBy(() -> RollCount.of(22))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEED_ROLL_COUNT);
        assertThatThrownBy(() -> RollCount.of(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BELOW_ROLL_COUNT);
    }
}