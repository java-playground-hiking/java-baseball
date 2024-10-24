package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import baseball.shared.MESSAGES;
import baseball.domain.ball.Ball;
import baseball.domain.ball.BallList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserTest {

    @ParameterizedTest
    @DisplayName("유저는 문자열 타입의 숫자 3개를 입력 받아야한다")
    @ValueSource(strings = {"1", "12", "1234"})
    void test_유저_유효성_검증(String ballNumber) {

        assertThatThrownBy(() -> {
                    User.of(ballNumber);
                }
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MESSAGES.USER_INSTANCE_ERROR_MESSAGE.getMessage());
    }

    @Test
    @DisplayName("유저는 문자열 타입의 숫자 3개를 입력 받아 BallList 값의 동등성이 보장된다")
    void test_유저_볼_동등성_검증() {
        assertThat(User.of("123").toBallList()).isEqualTo(
                BallList.of(List.of(Ball.of(0, 1), Ball.of(1, 2), Ball.of(2, 3)))
        );
    }


    @Test
    @DisplayName("유저는 문자열 타입의 숫자를 입력 받으면 숫자 자료형으로 변환 하여 Ball 객체를 생성한다")
    void test_유저_볼_자료형_검증() {
        List<Ball> userBalls = User.of("123").toBallList().getBalls();

        assertThat(userBalls).extracting(Ball::getNumber).containsExactly(1, 2, 3);
    }

}

