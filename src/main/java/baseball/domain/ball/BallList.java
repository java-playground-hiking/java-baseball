package baseball.domain.ball;

import baseball.shared.MESSAGES;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BallList {

    public static final int MAX_SIZE = 3;

    private final List<Ball> balls;

    public List<Ball> getBalls() {
        return new ArrayList<>(balls);
    }

    private BallList(List<Ball> balls) {
        if (balls.size() != MAX_SIZE) {
            throw new IllegalArgumentException(MESSAGES.BALL_LIST_INSTANCE_ERROR.getMessage());
        }

        this.balls = balls;
    }

    public static BallList of(List<Ball> balls) {
        return new BallList(balls);
    }

    public boolean containsBall(Ball ball) {
        return balls.stream()
                .anyMatch(b -> b.isAnotherPositionSameNumber(ball));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BallList ballList = (BallList) o;
        return Objects.equals(balls, ballList.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(balls);
    }
}
