package baseball.checker;

import baseball.matcher.NumberMatcher;
import baseball.matcher.PositionMatcher;
import baseball.config.Constants;
import java.util.List;

// 스트라이크 개수 계산
public class StrikeChecker {
    private final NumberMatcher numberMatcher;
    private final PositionMatcher positionMatcher;

    public StrikeChecker() {
        this.numberMatcher = new NumberMatcher();
        this.positionMatcher = new PositionMatcher();
    }

    public int countStrikes(List<Integer> guess, List<Integer> answer) {
        int strikeCount = Constants.ZERO;
        for (int i = 0; i < Constants.NUMBER_COUNT; i++) {
            if (isStrike(guess.get(i), answer, i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private boolean isStrike(int guessedNumber, List<Integer> answer, int index) {
        return numberMatcher.isMatching(guessedNumber, answer.get(index))
                && positionMatcher.isPositionMatching(answer, guessedNumber, index);
    }
}
