package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import study.message.ErrorMessages;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BaseballUtilsTest {

    @RepeatedTest(10)
    @DisplayName("랜덤 숫자 생성")
    void getRandomNumber() {
        // given
        // when
        int response = BaseballUtils.getRandomNumber();

        // then
        assertTrue(response > 0);
        assertTrue(response < 10);

    }


    @Test
    @DisplayName("String 을 List<Integer>로 변경")
    void convertIntToList(){
        // given
        String input = "123";

        // when
        List<Integer> response = BaseballUtils.stringToIntegerList(input);

        // then
        assertEquals(response.size(), 3);
        assertEquals(response.get(0), 1);
        assertEquals(response.get(1), 2);
        assertEquals(response.get(2), 3);
    }





    @Test
    @DisplayName("String 을 List<Integer>로 변경 시 숫자가 아닌 값 입력으로 예외 발생")
    void convertIntToList_exception(){
        // given
        String input = "문자열";

        // when
        NumberFormatException fail = assertThrows(NumberFormatException.class, () -> BaseballUtils.stringToIntegerList(input));

        // then
        assertEquals(fail.getMessage(), ErrorMessages.INVALID_INPUT_NUMBER);

    }


    @Test
    @DisplayName("String 을 Integer 로 변경")
    void stringParseInt(){
        // given
        String input = "1";

        // when
        int response = BaseballUtils.stringParseInt(input);

        // then
        assertEquals(response, Integer.parseInt(input));
    }

    @Test
    @DisplayName("String 을 Integer 로 변경 시 숫자 문자열이 아닌 값으로 인해 예외 발생")
    void stringParseIntInputNotNumber1_exception(){
        // given
        String input = "문자열";

        // when
        NumberFormatException fail = assertThrows(NumberFormatException.class, () -> BaseballUtils.stringParseInt(input));

        // then
        assertEquals(fail.getMessage(), ErrorMessages.INVALID_INPUT_NUMBER);
    }

    @Test
    @DisplayName("String 을 Integer 로 변경 시 숫자 문자열이 아닌 값으로 인해 예외 발생")
    void stringParseIntInputNotNumber2_exception(){
        // given
        String input = "_";

        // when
        NumberFormatException fail = assertThrows(NumberFormatException.class, () -> BaseballUtils.stringParseInt(input));

        // then
        assertEquals(fail.getMessage(), ErrorMessages.INVALID_INPUT_NUMBER);
    }

    @Test
    @DisplayName("문자열 길이 체크")
    void checkLength(){
        // given
        String input = "123";

        // when
        // then
        assertDoesNotThrow(() -> BaseballUtils.checkLength(input));
    }

    @Test
    @DisplayName("공백이 포함된 문자열 길이 체크")
    void checkLengthContainBlank(){
        // given
        String input = "12 3 ";

        // when
        assertDoesNotThrow(() -> BaseballUtils.checkLength(input));
    }

    @Test
    @DisplayName("문자열 길이 체크로 3자리 이상 문자열 입력 예외 발생")
    void checkLengthFalse(){
        // given
        String input = "12345";

        // when
        IllegalArgumentException fail =  assertThrows(IllegalArgumentException.class, () -> BaseballUtils.checkLength(input));

        // then
        assertEquals(fail.getMessage(), ErrorMessages.INVALID_INPUT_LENGTH);
    }





}
