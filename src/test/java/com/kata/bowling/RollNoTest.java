package com.kata.bowling;

import org.junit.jupiter.api.Test;

import static com.kata.bowling.RollNo.BELOW_ROLL_COUNT;
import static com.kata.bowling.RollNo.EXCEED_ROLL_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RollNoTest {
    @Test
    void create() {
        RollNo actual = RollNo.of(1);
        RollNo expected = RollNo.of(1);

        assertThat(actual).isEqualTo(expected);

    }

    // 범위 제한
    @Test
    void create_fail_range() {
        assertThatThrownBy(() -> RollNo.of(22))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEED_ROLL_COUNT);
        assertThatThrownBy(() -> RollNo.of(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BELOW_ROLL_COUNT);
    }
}