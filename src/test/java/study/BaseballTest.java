package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseballTest {

    @Test
    @DisplayName("3스트라이크")
    void playStrike(){
        // given
        BaseballAnswer baseballAnswer = new BaseballAnswer();
        List<Integer> answer = baseballAnswer.getAnswer();

        Baseball baseball = new Baseball(new BaseballScore(), baseballAnswer);

        // when
        BaseballScore response = baseball.play(answer);

        // then
        assertEquals(response.getStrike(), 3);
    }

    @Test
    @DisplayName("1스트라이크 2볼")
    void play1Strike2Ball(){
        // given
        BaseballAnswer baseballAnswer = new BaseballAnswer();
        List<Integer> answer = baseballAnswer.getAnswer();
        List<Integer> userInput = Arrays.asList(answer.get(0), answer.get(2), answer.get(1));

        Baseball baseball = new Baseball(new BaseballScore(), baseballAnswer);

        // when
        BaseballScore response = baseball.play(userInput);

        // then
        assertEquals(response.getStrike(), 1);
        assertEquals(response.getBall(), 2);
    }

    @Test
    @DisplayName("3볼")
    void play3Ball(){
        // given
        BaseballAnswer baseballAnswer = new BaseballAnswer();
        List<Integer> answer = baseballAnswer.getAnswer();
        List<Integer> userInput = Arrays.asList(answer.get(1), answer.get(2), answer.get(0));

        Baseball baseball = new Baseball(new BaseballScore(), baseballAnswer);

        // when
        BaseballScore response = baseball.play(userInput);

        // then
        assertEquals(response.getBall(), 3);
    }


    @Test
    @DisplayName("답 확인 : 스트라이크")
    void calculateScoreStrike(){
        // given
        BaseballAnswer baseballAnswer = new BaseballAnswer();
        List<Integer> answer = baseballAnswer.getAnswer();

        BaseballScore score = new BaseballScore();
        Baseball baseball = new Baseball(score, baseballAnswer);

        int index = 2;
        int input = answer.get(2);


        // when
        baseball.calculateScore(index, input);

        // then
        assertEquals(score.getStrike(), 1);
        assertEquals(score.getBall(), 0);
    }

    @Test
    @DisplayName("답 확인 : 볼")
    void calculateScoreBall(){
        // given
        BaseballAnswer baseballAnswer = new BaseballAnswer();
        List<Integer> answer = baseballAnswer.getAnswer();

        BaseballScore score = new BaseballScore();
        Baseball baseball = new Baseball(score, baseballAnswer);

        int index = 1;
        int input = answer.get(2);

        // when
        baseball.calculateScore(index, input);

        // then
        assertEquals(score.getStrike(), 0);
        assertEquals(score.getBall(), 1);
    }

    @Test
    @DisplayName("답 확인 : 낫싱")
    void calculateScoreNothing(){
        // given
        BaseballScore score = new BaseballScore();
        Baseball baseball = new Baseball(score, new BaseballAnswer());

        int index = 1;
        int input = 10;

        // when
        baseball.calculateScore(index, input);

        // then
        assertEquals(score.getStrike(), 0);
        assertEquals(score.getBall(), 0);
    }

}
