package baseball.game;

import baseball.model.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessCheckerTest {

    private GuessChecker guessChecker;
    private List<Integer> answer;

    @BeforeEach
    public void setUp() {
        answer = Arrays.asList(1, 2, 3);
        guessChecker = new GuessChecker(answer);
    }

    @Test
    @DisplayName("0 스트라이크, 0 볼 나오는지 확인해보셈")
    public void testNoStrikeNoBall() {
        List<Integer> guess = Arrays.asList(4, 5, 6);
        Result result = guessChecker.check(guess);
        assertEquals(0, result.getStrike(), "스트라이크는 0이어야 함");
        assertEquals(0, result.getBall(), "볼은 0이어야 함");
    }

    @Test
    @DisplayName("1 스트라이크, 1 볼 나오는지 확인해보셈")
    public void testOneStrikeOneBall() {
        List<Integer> guess = Arrays.asList(1, 3, 4);
        Result result = guessChecker.check(guess);
        assertEquals(1, result.getStrike(), "스트라이크는 1이어야 함");
        assertEquals(1, result.getBall(), "볼은 1이어야 함");
    }

    @Test
    @DisplayName("3 스트라이크 나오는지 확인해보셈")
    public void testThreeStrikes() {
        List<Integer> guess = Arrays.asList(1, 2, 3);
        Result result = guessChecker.check(guess);
        assertEquals(3, result.getStrike(), "스트라이크는 3이어야 함");
        assertEquals(0, result.getBall(), "볼은 0이어야 함");
    }
}
