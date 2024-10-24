package baseball.model;

import baseball.config.Constants;
import baseball.validation.Validator;

public class Result {
    private final int strike;
    private final int ball;

    // 생성자
    public Result(int strike, int ball) {
        Validator.validateStrikeAndBall(strike, ball); // 유효성 검증
        this.strike = strike;
        this.ball = ball;
    }

    // 스트라이크 개수 반환
    public int getStrike() {
        return strike;
    }

    // 볼 개수 반환
    public int getBall() {
        return ball;
    }

    // 정답 여부 확인
    public boolean isCorrect() {
        return strike == Constants.WINNING_STRIKES; // 상수로 대체
    }

    @Override
    public String toString() {
        return String.format("결과: %d 스트라이크, %d 볼!", strike, ball);
    }
}
