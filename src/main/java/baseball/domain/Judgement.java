package baseball.domain;


import baseball.domain.ball.Ball;
import baseball.domain.ball.BallList;
import baseball.domain.count.Count;
import java.util.List;
import java.util.stream.Collectors;

public class Judgement {

    public List<Count> judgeAllBalls(BallList userBalls, BallList comBalls) {
        return userBalls.getBalls().stream()
                .map(userBall -> judgeOneBall(userBall, comBalls))
                .collect(Collectors.toList());
    }

    public Count judgeOneBall(Ball userBall, BallList comBalls) {
        Ball comBall = comBalls.getBalls().get(userBall.getPosition());

        if (comBall.equals(userBall)) {
            return Count.STRIKE;
        }

        if (comBalls.containsBall(userBall)) {
            return Count.BALL;
        }

        return Count.NOTHING;
    }
}
