package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.exception.DivisionZeroException;
import study.exception.InvalidFormatException;
import study.exception.enumclass.ErrorCode;
import study.model.Operator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OperatorTest {
    private Operator operator;

    @BeforeEach
    void setUp(){
        operator = new Operator();
    }

    @Test
    @DisplayName("연산자 구분 함수 성공")
    void executeOperator_success(){
        // given
        String operators = "+";
        int nowValue = 1;
        int nextValue = 2;

        // when
        int result = operator.execute(operators, nowValue, nextValue);

        // then
        assertEquals(result, 1+2);
    }

    @Test
    @DisplayName("switch 문에 존재하지 않는 연산자 제공한 경우")
    void executeOperator_InvalidFormatException(){
        // given
        String operators = " ";
        int nowValue = 3;
        int nextValue = 2;

        // when
        InvalidFormatException fail = assertThrows(InvalidFormatException.class, () -> operator.execute(operators, nowValue, nextValue));

        // then
        assertEquals(fail.getMessage(), ErrorCode.INVALID_FORMAT.getMessage());
    }

    @Test
    @DisplayName("더하기 함수 성공")
    void add_success(){
        // given
        int num1 = 1, num2 = 2;

        // when
        int result = operator.add(num1, num2);

        // then
        assertEquals(result, 3);
    }

    @Test
    @DisplayName("빼기 함수 성공")
    void minus_success(){
        // given
        int num1 = 1, num2 = 2;

        // when
        int result = operator.minus(num1, num2);

        // then
        assertEquals(result, -1);
    }

    @Test
    @DisplayName("곱하기 함수 성공")
    void multiply_success(){
        // given
        int num1 = 5, num2 = 2;

        // when
        int result = operator.multiply(num1, num2);

        // then
        assertEquals(result, 10);
    }

    @Test
    @DisplayName("나누기 함수 성공")
    void divide_success(){
        // given
        int num1 = 5, num2 = 2;

        // when
        int result = operator.divide(num1, num2);

        // then
        assertEquals(result, 2);
    }

    @Test
    @DisplayName("0으로 나눈 경우")
    void divideZero_divisionZeroException(){
        // given
        int num1 = 5, num2 = 0;

        // when
        DivisionZeroException fail = assertThrows(DivisionZeroException.class,
                () -> operator.divide(num1, num2));

        // then
        assertEquals(fail.getMessage(), ErrorCode.DIVISION_ZERO.getMessage());
    }

}
