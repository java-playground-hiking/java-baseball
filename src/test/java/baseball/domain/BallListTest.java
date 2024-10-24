package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import baseball.domain.ball.Ball;
import baseball.domain.ball.BallList;
import baseball.shared.MESSAGES;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class BallListTest {

    @Test
    @DisplayName("BallList 컬렉션의 요소는 3개를 넘을 수 없다")
    void BallList_요소_갯수_초과() {
        assertThatThrownBy(() -> BallList.of(List.of(
                Ball.of(0, 1),
                Ball.of(1, 2),
                Ball.of(2, 3),
                Ball.of(3, 4)
        )))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MESSAGES.BALL_LIST_INSTANCE_ERROR.getMessage());

    }

    @Test
    @DisplayName("BallList 컬렉션의 요소는 3개 보다 적을 수 없다")
    void BallList_요소_갯수_미만() {
        assertThatThrownBy(() -> BallList.of(List.of(
                Ball.of(0, 1),
                Ball.of(1, 2)
        )))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MESSAGES.BALL_LIST_INSTANCE_ERROR.getMessage());

    }
}
