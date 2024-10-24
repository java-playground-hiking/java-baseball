package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.message.ErrorMessages;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BaseballGeneratorTest {

    @Test
    @DisplayName("사용자 입력값 리스트로 변경")
    void createUserInputList(){
        // given
        String input = "123";

        // when
        BaseballGenerator generator = new BaseballGenerator();
        List<Integer> response = generator.createUserInputList(input);

        // then
        assertEquals(response.size(), 3);
        assertEquals(response.get(0), 1);
        assertEquals(response.get(1), 2);
        assertEquals(response.get(2), 3);
    }



    @Test
    @DisplayName("공백이 포함된 사용자 입력값 리스트로 변경")
    void createUserInputListContainBlank(){
        // given
        String input = "12 3 ";

        // when
        BaseballGenerator generator = new BaseballGenerator();
        List<Integer> response = generator.createUserInputList(input);

        // then
        assertEquals(response.size(), 3);
        assertEquals(response.get(0), 1);
        assertEquals(response.get(1), 2);
        assertEquals(response.get(2), 3);
    }

    @Test
    @DisplayName("숫자가 아닌 문자열 입력으로 예외 발생")
    void createUserInputListInputOver3Length_exception(){
        // given
        String input = "문자열";

        // when
        BaseballGenerator generator = new BaseballGenerator();
        NumberFormatException fail = assertThrows(NumberFormatException.class, () -> generator.createUserInputList(input));

        // then
        assertEquals(fail.getMessage(), ErrorMessages.INVALID_INPUT_NUMBER);
    }


    @Test
    @DisplayName("정답 생성")
    void getAnswer(){
        // given
        // when
        BaseballGenerator generator = new BaseballGenerator();
        List<Integer> response = generator.createAnswer();

        // then
        assertEquals(response.size(), 3);
        assertNotEquals(response.get(0), response.get(1));
        assertNotEquals(response.get(0), response.get(2));
        assertNotEquals(response.get(1), response.get(2));
    }

}
