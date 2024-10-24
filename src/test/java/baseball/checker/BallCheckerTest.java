package baseball.checker;

import baseball.config.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BallCheckerTest {

    private BallChecker ballChecker;
    private List<Integer> answer;

    @BeforeEach
    @DisplayName("BallChecker랑 정답 리스트 초기화함")
    public void setUp() {
        ballChecker = new BallChecker();
        answer = Arrays.asList(1,2,3);
    }

    @Test
    @DisplayName("볼 없음: 예상한 숫자가 정답에 없을 때")
    public void testNoBalls() {
        List<Integer> guess = Arrays.asList(4, 5, 6);
        int balls = ballChecker.countBalls(guess, answer);
        assertEquals(Constants.ZERO, balls, "볼 없어야 됨.");
    }

    @Test
    @DisplayName("1개의 볼 있음: 1이 정답에 있지만 위치가 다를 때")
    public void testOneBall() {
        List<Integer> guess = Arrays.asList(4, 1, 6);
        int balls = ballChecker.countBalls(guess, answer);
        assertEquals(1, balls, "1개의 볼이어야 됨.");
    }

    @Test
    @DisplayName("2개의 볼 있음: 1이랑 3이 정답에 있지만 위치가 다를 때")
    public void testTwoBalls() {
        List<Integer> guess = Arrays.asList(3, 2, 1);
        int balls = ballChecker.countBalls(guess, answer);
        assertEquals(2, balls, "2개의 볼이어야 됨.");
    }

    @Test
    @DisplayName("3개의 볼 있음: 숫자 다 맞지만 위치 다를 때")
    public void testAllBalls() {
        List<Integer> guess = Arrays.asList(3, 1, 2);
        int balls = ballChecker.countBalls(guess, answer);
        assertEquals(3, balls, "3개의 볼이어야 됨.");
    }
}
