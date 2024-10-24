package baseball.domain;

import baseball.domain.ball.Ball;
import baseball.domain.ball.BallList;
import baseball.shared.MESSAGES;
import baseball.util.BaseballUtils;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class User {

    private final BallList balls;

    private User(List<Integer> balls) {
        this.balls = convertStringsToBallList(balls);
    }

    public static User of(String ballNumbers) {
        if (ballNumbers.length() != 3) {
            throw new IllegalArgumentException(MESSAGES.USER_INSTANCE_ERROR_MESSAGE.getMessage());
        }

        List<String> ballStringNumbers = BaseballUtils.splitByBlank(ballNumbers);
        List<Integer> ballIntegerNumbers = BaseballUtils.convertDataTypesIntoListData(ballStringNumbers);

        return new User(ballIntegerNumbers);
    }

    public BallList toBallList() {
        return balls;
    }

    private BallList convertStringsToBallList(List<Integer> ballNumbers) {
        List<Ball> ballList = IntStream.range(0, ballNumbers.size())
                .mapToObj(position -> Ball.of(position, ballNumbers.get(position)))
                .collect(Collectors.toList());
        return BallList.of(ballList);

    }
}
