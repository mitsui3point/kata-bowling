package com.kata.bowling;

import org.junit.jupiter.api.Test;

import static com.kata.bowling.FrameNo.BELOW_FRAME_NO;
import static com.kata.bowling.FrameNo.EXCEED_FRAME_NO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FrameNoTest {
    @Test
    void create() {
        FrameNo actual = FrameNo.of(1);
        FrameNo expected = FrameNo.of(1);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void create_fail_range() {
        assertThatThrownBy(() -> FrameNo.of(11))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEED_FRAME_NO);
        assertThatThrownBy(() -> FrameNo.of(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BELOW_FRAME_NO);
    }
}
