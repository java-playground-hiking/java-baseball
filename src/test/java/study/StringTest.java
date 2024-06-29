package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("주어진 `1, 2`에서 쉼표를 기준으로 분리 한 반환 값 검사")
    void 요구사항1_split1() {
        // Given
        String fixture = "1,2";

        // When
        String[] fixtureSplited = fixture.split(",");

        // Then
        assertThat(fixtureSplited).contains("1", "2");
    }

    @Test
    @DisplayName("주어진 `1`에서 쉼표를 기준으로 분리 한 반환 값 검사")
    void 요구사항1_split2() {
        // Given
        String fixture = "1";

        // When
        String[] fixtureSplited = fixture.split(",");

        // Then
        assertThat(fixtureSplited).containsExactly("1");
    }

    @Test
    @DisplayName("주어진 `(1, 2)`에서 괄호 제거 후 반환 값 검사")
    void 요구사항2_removeParentheses() {
        // Given
        String fixture = "(1,2)";

        // When
        String removeParentheses = fixture.substring(1, 4);

        // Then
        assertThat(removeParentheses).isEqualTo("1,2");
    }

    @ParameterizedTest
    @DisplayName("주어진 `a, b, c`에 개별 요소에 접근 하여 값의 일치 여부 검사")
    @CsvSource({"0,a", "1,b", "2,c"})
    void 요구사항3_getValues(int input, char input2) {
        // Given
        String fixture = "abc";

        // When
        char getChar = fixture.charAt(input);

        // Then
        assertThat(getChar).isEqualTo(input2);
    }

    @Test
    @DisplayName("문자열 개별 요소 접근 시 `IndexOutOfBound` 익셉션 발생")
    void 요구사항3_getValuesException() {
        // Given
        String fixture = "abc";

        // When
        assertThatThrownBy(() -> fixture.charAt(fixture.length() + 1))
                // Then
                .isInstanceOf(Exception.class)
                .hasMessageContaining("index out of range");

    }
}
