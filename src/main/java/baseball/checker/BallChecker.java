package baseball.checker;

import baseball.matcher.NumberMatcher;
import baseball.matcher.PositionMatcher;
import baseball.config.Constants;
import java.util.List;

public class BallChecker {
    private final NumberMatcher numberMatcher;
    private final PositionMatcher positionMatcher;

    public BallChecker() {
        this.numberMatcher = new NumberMatcher();
        this.positionMatcher = new PositionMatcher();
    }

    public int countBalls(List<Integer> guess, List<Integer> answer) {
        int ballCount = Constants.ZERO;
        for (int i = 0; i < Constants.NUMBER_COUNT; i++) {
            if (isBall(guess.get(i), answer, i)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private boolean isBall(int guessedNumber, List<Integer> answer, int index) {
        // 볼 조건: 위치가 맞지 않고 숫자가 정답에 포함된 경우
        return !positionMatcher.isPositionMatching(answer, guessedNumber, index)
                && answer.contains(guessedNumber);
    }
}
