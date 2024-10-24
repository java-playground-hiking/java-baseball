package baseball.domain.ball;

import baseball.shared.MESSAGES;
import java.util.Objects;

public class Ball {

    private static final int MIN = 1;
    private static final int MAX = 9;
    private final int number;
    private final int position;

    private Ball(int position, int number) {
        if (ballPositionValidation(position) || ballNumberValidation(number)) {
            throw new IllegalArgumentException(MESSAGES.BALL_INSTANCE_ERROR.getMessage());
        }

        this.position = position;
        this.number = number;
    }

    public static Ball of(int position, int number) {
        return new Ball(position, number);
    }

    public boolean isAnotherPositionSameNumber(Ball targetBall) {
        return (this.position != targetBall.getPosition()) && (this.number == targetBall.getNumber());
    }

    public int getNumber() {
        return number;
    }

    public int getPosition() {
        return position;
    }

    private boolean ballNumberValidation(int inputNumber) {
        return inputNumber < MIN || inputNumber > MAX;
    }

    private boolean ballPositionValidation(int inputPosition) {
        return inputPosition < 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return number == ball.number && position == ball.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
