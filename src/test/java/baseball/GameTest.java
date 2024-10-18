package baseball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    @DisplayName("정상적인 랜덤 숫자 생성 테스트")
    public void testGenerateRandomNumbers() {
        Game game = new Game();
        List<Integer> numbers = game.getAnswer();

        assertEquals(3, numbers.size(), "숫자 개수가 3개여야 됩니다.");
        assertTrue(numbers.stream().allMatch(n -> n >= 1 && n <= 9),
                "모든 숫자는 1에서 9 사이");
        assertEquals(3, numbers.stream().distinct().count(),
                "숫자는 중복되지 않됨.");
    }

    @Test
    @DisplayName("정답을 맞췄을 때 3 스트라이크 확인")
    public void testCheckGuessCorrect() {
        Game game = new Game(List.of(4, 2, 5));
        Result result = game.checkGuess(List.of(4, 2, 5));

        assertEquals(3, result.getStrike(), "3 스트라이크임.");
        assertEquals(0, result.getBall(), "볼이 없음.");
        assertTrue(result.isCorrect(), "정답을 맞췄으므로 게임이 종료.");
    }


}
