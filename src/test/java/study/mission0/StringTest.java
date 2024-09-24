package study.mission0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }


    @Test
    @DisplayName("요구사항 1 : split() 함수를 이용해 문자열을 분리시킨다.")
    void split(){
        String[] splitValues = "1,2".split(",");
        assertThat(splitValues).contains("1");
        assertThat(splitValues).containsExactly("1", "2"); // 원소가 정확히 일치하는지 확인
    }


    @Test
    @DisplayName("요구사항 2 : substring() 함수를 이용해 괄호를 제거 시킨다.")
    void substringParentheses(){
        String value = "(1,2)";
        String subValues = value.substring(1, value.length()-1);
        assertThat(subValues).isEqualTo("1,2");
    }


    @Test
    @DisplayName("요구사항 3 : chatAt() 메소드를 사용해 StringIndexOutOfBoundsException 을 발생시킨다.")
    void chatAt_StringIndexOutOfBoundsException(){
        String value = "abc";
        assertThrows(StringIndexOutOfBoundsException.class, () -> value.charAt(value.length()+1));
    }
}
