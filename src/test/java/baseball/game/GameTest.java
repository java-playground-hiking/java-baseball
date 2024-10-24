package baseball.game;

import baseball.model.Result;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    @DisplayName("랜덤 숫자 잘 생성됐는지 확인해보자")
    public void testGenerateRandomNumbers() {
        Game game = new Game();
        List<Integer> numbers = game.getAnswer();

        assertEquals(3, numbers.size(), "숫자 딱 3개 나와야 함.");
        assertTrue(numbers.stream().allMatch(n -> n >= 1 && n <= 9),
                "1에서 9 사이 숫자만 있어야 함.");
        assertEquals(3, numbers.stream().distinct().count(),
                "중복된 숫자 있으면 안 됨.");
    }

    @Test
    @DisplayName("정답 맞췄을 때 3 스트라이크인지 체크하자")
    public void testCheckGuessCorrect() {
        Game game = new Game(List.of(4, 2, 5));
        Result result = game.checkGuess(List.of(4, 2, 5));

        assertEquals(3, result.getStrike(), "3 스트라이크 나왔음.");
        assertEquals(0, result.getBall(), "볼 하나도 없음.");
        assertTrue(result.isCorrect(), "정답 맞췄으니까 게임 끝났음.");
    }
}
