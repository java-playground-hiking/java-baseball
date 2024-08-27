package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import domain.User;
import core.AppException;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserPlayerTest {

    @DisplayName("플레이어는 3자리 숫자만 입력 할 수 있다")
    @Test
    void 유저_입력_자리수_검증() {
        // Given
        String inputFixture = "1234";

        // When
        assertThatThrownBy(() -> {
            User user = new User(inputFixture);
        })
                // Then
                .isInstanceOf(AppException.class)
                .hasMessageContaining("입력한 숫자의 길이가 올바르지 않습니다.");
    }

    @DisplayName("유저는 문자를 입력 할 수 없다")
    @Test
    void 유저_입력_자료형_검증() {
        // Given
        String userInputFixture = "asd";

        // When
        assertThatThrownBy(() -> {
            User user = new User(userInputFixture);
        })
                // Then
                .isInstanceOf(AppException.class)
                .hasMessageContaining("지정 되지 않은 타입의 입력입니다.");
    }

    @DisplayName("유저는 0을 입력 할 수 없다")
    @Test
    void 유저_입력_0_검증() {
        // Given
        String userInputFixture = "120";

        // When
        assertThatThrownBy(() -> {
            User user = new User(userInputFixture);
        })
                // Then
                .isInstanceOf(AppException.class)
                .hasMessageContaining("0은 입력 할 수 없습니다.");
    }

    @DisplayName("유저가 정상적으로 입력한 숫자를 문자 타입의 배열로 반환한다")
    @Test
    void 유저_정상입력_반환() {
        // Given
        String userInputFixture = "123";

        // When
        User user = new User(userInputFixture);

        // Then
        assertThat(user.getUserInputNumbers()).isInstanceOf(ArrayList.class);
        assertThat(user.getUserInputNumbers()).isEqualTo(new ArrayList<>(Arrays.asList("1", "2", "3")));
    }
}