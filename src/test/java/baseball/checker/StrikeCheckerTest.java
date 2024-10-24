package baseball.checker;

import baseball.config.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrikeCheckerTest {

    private StrikeChecker strikeChecker;
    private List<Integer> answer;

    @BeforeEach
    @DisplayName("StrikeChecker랑 정답 리스트 초기화함")
    public void setUp() {
        strikeChecker = new StrikeChecker();
        answer = Arrays.asList(1, 2, 3);
    }

    @Test
    @DisplayName("스트라이크 없음: 예상한 숫자가 정답이랑 안 맞을 때")
    public void testNoStrikes() {
        List<Integer> guess = Arrays.asList(4, 5, 6);
        int strikes = strikeChecker.countStrikes(guess, answer);
        assertEquals(Constants.ZERO, strikes, "스트라이크 없음.");
    }

    @Test
    @DisplayName("1개 스트라이크: 하나 맞고 위치도 맞을 때")
    public void testOneStrike() {
        List<Integer> guess = Arrays.asList(1, 5, 6);
        int strikes = strikeChecker.countStrikes(guess, answer);
        assertEquals(1, strikes, "1개의 스트라이크임.");
    }

    @Test
    @DisplayName("2개 스트라이크: 두 개 맞고 위치도 맞을 때")
    public void testTwoStrikes() {
        List<Integer> guess = Arrays.asList(1, 2, 6);
        int strikes = strikeChecker.countStrikes(guess, answer);
        assertEquals(2, strikes, "2개의 스트라이크임.");
    }

    @Test
    @DisplayName("3개 스트라이크: 전부 다 맞을 때")
    public void testThreeStrikes() {
        List<Integer> guess = Arrays.asList(1, 2, 3);
        int strikes = strikeChecker.countStrikes(guess, answer);
        assertEquals(3, strikes, "3개의 스트라이크임.");
    }
}
