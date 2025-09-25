package com.kata.bowling;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/*
 이 게임은 10프레임으로 구성됩니다.
 각 프레임마다 플레이어는 10개의 핀을 쓰러뜨릴 수 있는 두 번의 주사위를 굴립니다.
 각 프레임의 점수는 쓰러뜨린 핀의 총 개수에 스트라이크와 스페어에 대한 보너스를 더한 값입니다.

 스페어는 플레이어가 두 번의 굴림으로 10개의 핀을 모두 쓰러뜨리는 것을 말합니다.
 해당 프레임의 보너스는 다음 굴림에서 쓰러뜨린 핀의 개수입니다.

 스트라이크는 플레이어가 첫 번째 굴림에서 10개의 핀을 모두 쓰러뜨리는 것을 말합니다.
 그 후 프레임은 한 번의 굴림으로 끝납니다.
 해당 프레임의 보너스는 다음 두 번의 굴림의 결과입니다.

 10번째 프레임에서 스페어나 스트라이크를 던진 선수는 추가 공을 굴려 프레임을 완료할 수 있습니다.
 단, 10번째 프레임에는 최대 3개의 공을 굴릴 수 있습니다.

 요구 사항
     Game 두 개의 메서드가 있는 클래스를 작성하세요

     void roll(int)플레이어가 공을 굴릴 때마다 호출됩니다. 인수는 쓰러진 핀의 개수입니다.
     int score()해당 게임의 총점을 반환합니다.
=============================================

생성자 대신 정적 팩토리 메서드

Game
    Frame
    method
        roll
        score

Frame
    FrameCount count
    Score score
    method
        score

FrameCount
    int count(1~10)
    method
        isLastFrame == 10
        next(roll)

Roll
    RollCount count
    Roll prev
    Pin pin
    Status status
    Score score
    Frame frame
    : method
        roll()
        isFirst() == 1
        isSecond() == n
        isBonus() == 3
        totalScore()

RollCount
    int count

Pin
    PinCount stand
    PinCount down
    method
        breakdown()

PinCount
    int count
    method
        breakDown()

Score
    int score
*/
@Slf4j
class GameTest {

    @Test
    void roll() {
        log.info("roll");
    }

    @Test
    void score() {
        log.info("score");
    }
}
