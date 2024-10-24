package baseball.domain;


import static org.assertj.core.api.Assertions.*;

import baseball.domain.ball.Ball;
import baseball.domain.ball.BallList;
import baseball.domain.count.Count;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JudgementTest {

    private static Judgement judgement;
    private static BallList comBalls;

    @BeforeAll
    public static void setUp() {
        judgement = new Judgement();
        comBalls = BallList.of(
                List.of(
                        Ball.of(0, 4),
                        Ball.of(1, 5),
                        Ball.of(2, 6)
                )
        );
    }

    @Test
    @DisplayName("유저와 컴퓨터의 Ball 속성 값 중 number만 같으면 볼이다")
    void test_Ball_비교_1볼() {
        assertThat(
                judgement.judgeOneBall(
                        Ball.of(0, 5),
                        comBalls
                )
        ).isEqualTo(Count.BALL);
    }

    @Test
    @DisplayName("유저와 컴퓨터의 Ball 속성 값이 모두 같으면 스트라이크이다")
    void test_Ball_비교_1스트라이크() {
        assertThat(
                judgement.judgeOneBall(
                        Ball.of(0, 4),
                        comBalls
                )
        ).isEqualTo(Count.STRIKE);
    }

    @Test
    @DisplayName("유저와 컴퓨터의 Ball 속성 값이 모두 다르면 낫띵이다")
    void test_Ball_비교_낫띵() {
        assertThat(
                judgement.judgeOneBall(
                        Ball.of(0, 3),
                        comBalls
                )
        ).isEqualTo(Count.NOTHING);
    }

    @Test
    @DisplayName("유저와 컴퓨터의 BallList 요소의 속성 값이 모두 다르면 낫띵")
    void test_BallList_비교_낫띵() {
        BallList userBalls = BallList.of(
                List.of(
                        Ball.of(0, 1),
                        Ball.of(1, 2),
                        Ball.of(2, 3)
                )
        );

        assertThat(judgement.judgeAllBalls(userBalls, comBalls)).isEqualTo(
                List.of(Count.NOTHING, Count.NOTHING, Count.NOTHING));

    }

    @Test
    @DisplayName("유저와 컴퓨터의 BallList 요소의 속성 값 중 같은 요소가 있다면 스트라이크")
    void test_BallList_비교_스트라이크() {
        BallList userBalls = BallList.of(
                List.of(
                        Ball.of(0, 4),
                        Ball.of(1, 2),
                        Ball.of(2, 3)
                )
        );

        assertThat(judgement.judgeAllBalls(userBalls, comBalls)).isEqualTo(
                List.of(Count.STRIKE, Count.NOTHING, Count.NOTHING));
    }

    @Test
    @DisplayName("유저와 컴퓨터의 BallList 요소의 속성 값 중 같은 포지션만 같다면 볼")
    void test_BallList_비교_볼() {
        BallList userBalls = BallList.of(
                List.of(
                        Ball.of(0, 1),
                        Ball.of(1, 4),
                        Ball.of(2, 3)
                )
        );

        assertThat(judgement.judgeAllBalls(userBalls, comBalls)).isEqualTo(
                List.of(Count.NOTHING, Count.BALL, Count.NOTHING));
    }
}

