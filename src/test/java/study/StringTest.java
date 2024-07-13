package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @DisplayName("문자열 일치 테스트")
    @Test
    void replace() {
        String actual = "abc".replace("b", "d"); //실행 단계
        assertThat(actual).isEqualTo("adc"); //검증 단계
    }

    @DisplayName("문자열 split() 테스트")
    @Test
    void split() {
        //given
        String str1 = "1,2";
        String str2 = "1";

        //when
        String[] actual1 = str1.split(",");
        String[] actual2 = str2.split(",");

        //then
        assertThat(actual1).containsExactly("1", "2");
        assertThat(actual2).containsExactly("1");
    }

    @DisplayName("문자열 substring() 테스트")
    @Test
    void substring() {
        //given
        String str = "(1,2)";

        //when
        String actual = str.substring(1, str.length() - 1);

        //then
        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName("문자열 charAt() 테스트")
    @Test
    void charAt() {
        //given
        String str = "abc";

        //when
        Throwable thrown = catchThrowable(() -> str.charAt(3));

        //then
        assertThat(thrown)
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
