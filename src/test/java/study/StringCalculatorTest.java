package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.exception.DivisionZeroException;
import study.exception.InvalidFormatException;
import study.exception.enumclass.ErrorCode;
import study.exception.InvalidInputException;
import study.model.StringCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2, 10", "2 - 3 / 4 + 7, 7", "10 + 3 * 86 - 20, 1098"})
    @DisplayName("StringCalculator 계산 성공")
    void stringCalculator_success(String input, int expected){
        // given
        // when
        int result = calculator.calculate(input);
        
        // then
        assertEquals(result, expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"d + 3 * 4 / 2", "2 - ( / 4 + 7", "10 + 3 * 86 - #", "6 + number * 5 / 20"})
    @DisplayName("입력한 문자가 숫자가 아닌 경우")
    void inputNotNumberAtFirst_invalidInputException(String input){
        // given
        // when
        InvalidInputException fail = assertThrows(InvalidInputException.class,
                () -> calculator.calculate(input));

        // then
        assertEquals(fail.getMessage(), ErrorCode.NON_NUMERIC_INPUT.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"3 / 0", "3 + 2 / 0", "4 * 2 / 0 + 7"})
    @DisplayName("0으로 나눌 경우")
    void divisionZero_divisionZeroException(String input){
        // given
        // when
        DivisionZeroException fail = assertThrows(DivisionZeroException.class,
                () -> calculator.calculate(input));

        // then
        assertEquals(fail.getMessage(), ErrorCode.DIVISION_ZERO.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"3 / ", "65 + 2 *", "2 - 3 +     "})
    @DisplayName("완벽하지 않은 수식을 입력할 경우")
    void notPerfectFormat_invalidFormatException(String input){
        // given
        // when
        InvalidFormatException fail = assertThrows(InvalidFormatException.class,
                () -> calculator.calculate(input));

        // then
        assertEquals(fail.getMessage(), ErrorCode.INVALID_FORMAT.getMessage());
    }

    @Test
    @DisplayName("계산에 사용할 다음 숫자 구하는 함수 테스트 성공")
    void getNextValue_success(){
        // given
        String[] values = {"1", "+", "2"};
        int index = 2;

        // when
        int result = calculator.getNextValue(values, index);

        // then
        assertEquals(result, 2);
    }

    @Test
    @DisplayName("계산에 사용할 다음 숫자를 구하는 함수 테스트 중 배열의 범위가 넘은 경우")
    void getNextValue_invalidFormatException(){
        // given
        String[] values = {"1", "+", "2"};
        int index = 10;

        // when
        InvalidFormatException fail = assertThrows(InvalidFormatException.class,
                () -> calculator.getNextValue(values, index));

        // then
        assertEquals(fail.getMessage(), ErrorCode.INVALID_FORMAT.getMessage());
    }

    @Test
    @DisplayName("String 을 Integer 로 변경하는 함수 테스트 성공")
    void parseInteger_success(){
        // given
        String value = "10";

        // when
        int result = calculator.parseInteger(value);

        // then
        assertEquals(result, 10);
    }

    @Test
    @DisplayName("String 을 Integer 변경 시 실패로 인한 InvalidInputException 발생한 경우")
    void parseInteger_invalidInputException(){
        // given
        String value = "#";

        // when
        InvalidInputException fail = assertThrows(InvalidInputException.class,
                () -> calculator.parseInteger(value));

        // then
        assertEquals(fail.getMessage(), ErrorCode.NON_NUMERIC_INPUT.getMessage());
    }


}
