package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 검사")
    void split1() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1","2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 검사")
    void split2() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2) 값에서 () 제거 후 반환 검사")
    void substring() {
        String actual = "(1,2)";
        String result  = actual.substring(1, actual.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열의 특정 위치의 문자를 가져올 때, 인덱스를 벗어나면 예외 발생")
    void charAt() {
        String actual = "abc";
        assertThatThrownBy(() -> {
            actual.charAt(20);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}
