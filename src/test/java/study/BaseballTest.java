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
        List<Integer> answer = Arrays.asList(1, 2, 3);
        List<Integer> userInput = Arrays.asList(1, 2, 3);

        Baseball baseball = new Baseball(new BaseballScore(), answer);

        // when
        BaseballScore response = baseball.play(userInput);

        // then
        assertEquals(response.getStrike(), 3);
    }

    @Test
    @DisplayName("1스트라이크 2볼")
    void play1Strike2Ball(){
        // given
        List<Integer> answer = Arrays.asList(1, 2, 3);
        List<Integer> userInput = Arrays.asList(1, 3, 2);

        Baseball baseball = new Baseball(new BaseballScore(), answer);

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
        List<Integer> answer = Arrays.asList(1, 2, 3);
        List<Integer> userInput = Arrays.asList(3, 1, 2);

        Baseball baseball = new Baseball(new BaseballScore(), answer);

        // when
        BaseballScore response = baseball.play(userInput);

        // then
        assertEquals(response.getBall(), 3);
    }

    @Test
    @DisplayName("낫씽")
    void playNothing(){
        // given
        List<Integer> answer = Arrays.asList(1, 2, 3);
        List<Integer> userInput = Arrays.asList(4, 5, 6);

        Baseball baseball = new Baseball(new BaseballScore(), answer);

        // when
        BaseballScore response = baseball.play(userInput);

        // then
        assertEquals(response.getBall(), 0);
        assertEquals(response.getBall(), 0);
    }

}
