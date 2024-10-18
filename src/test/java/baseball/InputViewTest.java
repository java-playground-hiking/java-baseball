package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InputViewTest {

    @Test
    @DisplayName("정상적인 입력 테스트")
    public void testValidInput() {
        // 사용자 입력을 시뮬레이션 (Scanner 대신 직접 입력 전달)
        String input = "123";
        List<Integer> numbers = InputView.extractNumbers(input);

        assertEquals(3, numbers.size(), "숫자 개수가 3개여야 합니다.");
        assertTrue(numbers.containsAll(List.of(1, 2, 3)), "입력된 숫자는 1, 2, 3이어야 합니다.");
    }

    @Test
    @DisplayName("빈 입력값 테스트")
    public void testEmptyInputThrowsException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> InputView.validateRawInput("")
        );
        assertEquals("입력값이 비어있습니다. 숫자 3개를 입력하세요.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"12", "1234", "12a", "1,2,3", "1 2 3"})
    @DisplayName("잘못된 입력값에 대한 테스트")
    public void testInvalidInputThrowsException(String input) {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> InputView.validateRawInput(input)
        );
        assertTrue(exception.getMessage().startsWith("입력값은 정확히") ||
                        exception.getMessage().startsWith("입력값에는"),
                "예외 메시지가 정확히");
    }

    @Test
    @DisplayName("중복된 숫자 입력 테스트")
    public void testDuplicateNumbersThrowsException() {
        List<Integer> numbers = List.of(1, 1, 2);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> InputView.validateNumbers(numbers)
        );
        assertEquals("각 숫자는 중복되지 않아야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("범위 밖의 숫자 입력 테스트")
    public void testOutOfRangeNumbersThrowsException() {
        List<Integer> numbers = List.of(1, 10, 2);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> InputView.validateNumbers(numbers)
        );
        assertEquals("엥간하면 0이하 10 이상은 하지 말자", exception.getMessage());
    }

    @Test
    @DisplayName("공백이 포함된 입력 처리 테스트")
    public void testInputWithSpaces() {
        String input = " 1 2 3 ";
        List<Integer> numbers = InputView.extractNumbers(input);

        assertEquals(3, numbers.size(), "숫자 개수가 3개여야 합니다.");
        assertTrue(numbers.containsAll(List.of(1, 2, 3)), "공백 처리 쏘 괜츈");
    }

    @Test
    @DisplayName("특수문자 포함된 입력 처리 테스트")
    public void testInputWithSpecialCharacters() {
        String input = "1,2,3";
        List<Integer> numbers = InputView.extractNumbers(input);

        assertEquals(3, numbers.size(), "숫자 개수가 3개여야 합니다.");
        assertTrue(numbers.containsAll(List.of(1, 2, 3)), "특수 문자 X , 숫자만 가능 합니다.");
    }
}
