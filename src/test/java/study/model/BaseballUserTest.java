package study.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.message.ErrorMessages;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BaseballUserTest {

    @Test
    @DisplayName("사용자 입력 값이 담긴 BaseballUser 클래스 생성")
    void baseballUser(){
        // given
        String userInput = "123";

        // when
        BaseballUser user = new BaseballUser(userInput);

        // then
        assertEquals(user.getUserInputNumber(0), 1);
        assertEquals(user.getUserInputNumber(1), 2);
        assertEquals(user.getUserInputNumber(2), 3);
    }

    @Test
    @DisplayName("BaseballUser 클래스 생성 시 사용자 입력에 공백이 포함되어 있어도 공백 제거 후 클래스 생성 성공")
    void baseballUserContainsSpaces(){
        // given
        String userInput = "12 3";

        // when
        BaseballUser user = new BaseballUser(userInput);

        // then
        assertEquals(user.getUserInputNumber(0), 1);
        assertEquals(user.getUserInputNumber(1), 2);
        assertEquals(user.getUserInputNumber(2), 3);
    }

    @Test
    @DisplayName("BaseballUser 클래스 생성 시 사용자 입력 길이가 3자리가 아니여서 예외 발생")
    void baseballUserInputNot3Length_exception(){
        // given
        String userInput = "3";

        // when
        IllegalArgumentException fail =  assertThrows(IllegalArgumentException.class, () -> new BaseballUser(userInput));

        // then
        assertEquals(fail.getMessage(), ErrorMessages.INVALID_INPUT_LENGTH);

    }

    @Test
    @DisplayName("BaseballUser 클래스 생성 시 사용자 입력에 숫자 문자열이 아닌 값이 포함되 예외 발생")
    void baseballUserInputNotNumber_exception(){
        // given
        String userInput = "1자리";

        // when
        NumberFormatException fail = assertThrows(NumberFormatException.class, () -> new BaseballUser(userInput));

        // then
        assertEquals(fail.getMessage(), ErrorMessages.INVALID_INPUT_NUMBER);

    }

    @Test
    @DisplayName("InputValidate 클래스 이용해 입력 값 검증")
    void innerClassValidate(){
        // given
        String userInput = "123";

        BaseballUser.InputValidate validate = new BaseballUser.InputValidate(userInput);

        // when
        List<Integer> response = validate.validate();

        assertEquals(response.get(0), 1);
        assertEquals(response.get(1), 2);
        assertEquals(response.get(2), 3);

    }

    @Test
    @DisplayName("InputValidate inner 클래스 이용해 입력 값 검증 시 입력 값에 공백 포함된 경우")
    void innerClassValidateContainsSpaces(){
        // given
        String userInput = "1 23    ";

        BaseballUser.InputValidate inputValidate = new BaseballUser.InputValidate(userInput);

        // when
        List<Integer> response = inputValidate.validate();

        assertEquals(response.get(0), 1);
        assertEquals(response.get(1), 2);
        assertEquals(response.get(2), 3);

    }

    @Test
    @DisplayName("InputValidate inner 클래스 이용해 입력 값 검증 시 사용자 입력 길이가 3자리가 아니여서 예외 발생")
    void innerClassInputNot3Length_exception(){
        // given
        String userInput = "3";

        BaseballUser.InputValidate inputValidate = new BaseballUser.InputValidate(userInput);

        // when
        IllegalArgumentException fail =  assertThrows(IllegalArgumentException.class, () -> inputValidate.validate());

        // then
        assertEquals(fail.getMessage(), ErrorMessages.INVALID_INPUT_LENGTH);

    }

    @Test
    @DisplayName("InputValidate inner 클래스 이용해 입력 값 검증 시 숫자 문자열이 아닌 값이 포함되 예외 발생")
    void innerClassInputNotNumber_exception(){
        // given
        String userInput = "1자리";

        BaseballUser.InputValidate inputValidate = new BaseballUser.InputValidate(userInput);
        // when
        NumberFormatException fail = assertThrows(NumberFormatException.class, () -> inputValidate.validate());

        // then
        assertEquals(fail.getMessage(), ErrorMessages.INVALID_INPUT_NUMBER);

    }

}
