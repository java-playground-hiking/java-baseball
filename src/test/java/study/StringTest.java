package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split_contains() {
        //given
        String actual = "1,2";

        //when
        String[] splitStrList = actual.split(",");

        //then
        assertAll(
                () -> assertThat(splitStrList).contains("1"),
                () -> assertThat(splitStrList).contains("2")
        );
    }

    @Test
    void split_containsExactly() {
        //given
        String actual = "1";

        //when
        String[] splitStrList = actual.split(",");
        //then
        assertThat(splitStrList).containsExactly("1");
    }

    @Test
    void substring() {
        //given
        String actual = "(1,2)";

        //when
        String subStr = actual.substring(1,actual.length()-1);

        //then
        assertThat(subStr).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt에서 인덱스 벗어났을 경우")
    void charAt() {
        //given
        String actual = "abc";
        //when
        int idx = actual.length();
        //then
        assertThatThrownBy(()->{
            actual.charAt(idx);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
