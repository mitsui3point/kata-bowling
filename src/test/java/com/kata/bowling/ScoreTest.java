package com.kata.bowling;

import org.junit.jupiter.api.Test;

import static com.kata.bowling.Score.NOT_ALLOWED_EXCEED_MAX_VALUE;
import static com.kata.bowling.Score.NOT_ALLOWED_MINUS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ScoreTest {

    @Test
    void create() {
        Score actual = Score.of(40);
        Score expected = Score.of(40);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void create_fail_range() {
        assertThatThrownBy(() -> Score.of(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ALLOWED_MINUS);
        assertThatThrownBy(() -> Score.of(301))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ALLOWED_EXCEED_MAX_VALUE);
    }

}