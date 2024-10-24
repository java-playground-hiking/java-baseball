package baseball.validation;

import baseball.config.Constants;

import java.util.List;

public class Validator {

    public void validate(List<Integer> guess) {
        validateSize(guess);
        validateDuplicates(guess);
        validateRange(guess);
    }

    private void validateSize(List<Integer> guess) {
        if (guess.size() != Constants.NUMBER_COUNT) {
            throw new IllegalArgumentException("숫자 " + Constants.NUMBER_COUNT + "개를 정확히 입력해야 합니다.");
        }
    }

    private void validateDuplicates(List<Integer> guess) {
        if (guess.stream().distinct().count() != Constants.NUMBER_COUNT) {
            throw new IllegalArgumentException("각 숫자는 중복되지 않아야 합니다.");
        }
    }

    private void validateRange(List<Integer> guess) {
        if (!guess.stream().allMatch(n -> n >= Constants.MIN_NUMBER && n <= Constants.MAX_NUMBER)) {
            throw new IllegalArgumentException("모든 숫자는 " + Constants.MIN_NUMBER + "에서 " + Constants.MAX_NUMBER + " 사이여야 합니다.");
        }
    }

    public static void validateStrikeAndBall(int strike, int ball) {
        if (strike < 0 || ball < 0) {
            throw new IllegalArgumentException("스트라이크랑 볼 개수는 음수일 수 없음!");
        }
    }
}
