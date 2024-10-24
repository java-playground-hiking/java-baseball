package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseballScoreTest {

    @Test
    @DisplayName("스트라이크 점수 증가")
    void addStrike() {
        // given

        // when
        BaseballScore score = new BaseballScore();
        score.addStrike();

        // then
        assertEquals(score.getStrike(), 1);
    }

    @Test
    @DisplayName("볼 점수 증가")
    void addBall() {
        // given

        // when
        BaseballScore score = new BaseballScore();
        score.addBall();

        // then
        assertEquals(score.getBall(), 1);
    }


    @Test
    @DisplayName("점수 출력 : 3스트라이크")
    void printScore3Strike(){
        // given
        BaseballScore score = new BaseballScore();
        score.addStrike();
        score.addStrike();
        score.addStrike();

        // when
        String response = score.printScore();

        // then
        assertEquals(response, "3스트라이크");

    }

    @Test
    @DisplayName("점수 출력 : 1볼 2스트라이크")
    void printScore1Ball2Strike(){
        // given
        BaseballScore score = new BaseballScore();
        score.addBall();
        score.addStrike();
        score.addStrike();

        // when
        String response = score.printScore();

        // then
        assertEquals(response, "1볼 2스트라이크");

    }

    @Test
    @DisplayName("점수 출력 : 3볼")
    void printScore3Ball(){
        // given
        BaseballScore score = new BaseballScore();
        score.addBall();
        score.addBall();
        score.addBall();

        // when
        String response = score.printScore();

        // then
        assertEquals(response, "3볼");
    }

    @Test
    @DisplayName("점수 출력 : 낫싱")
    void printScoreNothing(){
        // given
        BaseballScore score = new BaseballScore();

        // when
        String response = score.printScore();

        // then
        assertEquals(response, "낫싱");
    }

    @Test
    @DisplayName("3스크라이크 여부")
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
    @DisplayName("3스크라이크 여부")
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
