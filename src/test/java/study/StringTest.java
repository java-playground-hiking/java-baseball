package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        //given
        String actual = "1,2";

        //when1
        String[] spltedStrList = actual.split(",");
        //then1
        assertThat(spltedStrList).contains("1");
        assertThat(spltedStrList).contains("2");

        //given
        String actual2 = "1";

        //when2
        String[] spltedStrList2 = actual2.split(",");
        //then2
        assertThat(spltedStrList2).containsExactly("1");
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
