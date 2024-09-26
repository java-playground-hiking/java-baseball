import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    StringCalculator calculator = new StringCalculator();

    public static void inputHandling(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
    }

    @Test
    void add() {
        inputHandling("2 + 3 + 4 + 5");
        assertThat(calculator.execute()).isEqualTo(14);
    }

    @Test
    void subtract() {
        inputHandling("10 - 2 - 3 - 6");
        assertThat(calculator.execute()).isEqualTo(-1);
    }

    @Test
    void multiply() {
        inputHandling("2 * 3 * 4 * 5");
        assertThat(calculator.execute()).isEqualTo(120);
    }

    @Test
    void divide() {
        inputHandling("20 / 2 / 5");
        assertThat(calculator.execute()).isEqualTo(2);
    }

    @Test
    @DisplayName("[예외] 문자열 추가")
    void stringInputExceptionTest() {
        inputHandling("1 C 3 * 4 / 2");
        assertThatThrownBy(() -> calculator.execute()).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("연산자");
    }

    @Test
    @DisplayName("[예외] 공백 입력")
    void blanckInputExceptionTest() {
        inputHandling("");
        assertThat(calculator.execute()).isEqualTo(0);
    }

}