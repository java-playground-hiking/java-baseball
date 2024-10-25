package study.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.model.BaseballScore;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultViewTest {
    @Test
    @DisplayName("점수 출력 : 3스트라이크")
    void printScore3Strike(){
        // given
        BaseballScore score = new BaseballScore();
        score.addStrike();
        score.addStrike();
        score.addStrike();

        ResultView resultView = new ResultView();

        // when
        String response = resultView.printScore(score);

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

        ResultView resultView = new ResultView();

        // when
        String response = resultView.printScore(score);

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

        ResultView resultView = new ResultView();

        // when
        String response = resultView.printScore(score);

        // then
        assertEquals(response, "3볼");
    }

    @Test
    @DisplayName("점수 출력 : 낫싱")
    void printScoreNothing(){
        // given
        BaseballScore score = new BaseballScore();
        ResultView resultView = new ResultView();

        // when
        String response = resultView.printScore(score);

        // then
        assertEquals(response, "낫싱");
    }
}
