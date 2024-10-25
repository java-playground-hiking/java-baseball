package study.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseballScoreTest {

    @Test
    @DisplayName("스트라이크 점수 증가")
    void addStrike() {
        // given
        BaseballScore score = new BaseballScore();

        // when
        score.addStrike();

        // then
        assertEquals(score.getStrike(), 1);
    }

    @Test
    @DisplayName("볼 점수 증가")
    void addBall() {
        // given
        BaseballScore score = new BaseballScore();

        // when
        score.addBall();

        // then
        assertEquals(score.getBall(), 1);
    }

    @Test
    @DisplayName("3스트라이크인 경우 true 반환")
    void isThreeStrikeTrue(){
        // given
        BaseballScore score = new BaseballScore();
        score.addStrike();
        score.addStrike();
        score.addStrike();

        // when
        boolean response = score.isThreeStrike();

        // then
        assertEquals(response, true);

    }

    @Test
    @DisplayName("3스트라이크가 아닌 경우 false 반환")
    void isThreeStrikeFalse(){
        // given
        BaseballScore score = new BaseballScore();
        score.addStrike();
        score.addStrike();

        // when
        boolean response = score.isThreeStrike();

        // then
        assertEquals(response, false);

    }

}
