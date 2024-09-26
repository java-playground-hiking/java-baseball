package study.calculator;

import calculator.model.Operator;
import calculator.utils.StringException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class OperatorTest {
    @DisplayName("덧셈 연산자 계산 테스트")
    @Test
    void plusCalculateTest() {
        //given
        int operand1 = 2, operand2 = 34;

        //when
        int result = Operator.PLUS.calculate(operand1, operand2);

        //then
        assertThat(result).isEqualTo(36);
    }

    @DisplayName("뺄셈 연산자 계산 테스트")
    @Test
    void minusCalculationTest() {
        //given
        int operand1 = 2, operand2 = 34;

        //when
        int result = Operator.MINUS.calculate(operand1, operand2);

        //then
        assertThat(result).isEqualTo(-32);
    }

    @DisplayName("곱셈 연산자 계산 테스트")
    @Test
    void multiplyCalculationTest() {
        //given
        int operand1 = 2, operand2 = 34;

        //when
        int result = Operator.MULTIPLY.calculate(operand1, operand2);

        //then
        assertThat(result).isEqualTo(68);
    }

    @DisplayName("나눗셈 연산자 계산 테스트")
    @Test
    void divideCalculationTest() {
        //given
        int operand1 = 100, operand2 = 5;

        //when
        int result = Operator.DIVIDE.calculate(operand1, operand2);

        //then
        assertThat(result).isEqualTo(20);
    }

    @DisplayName("나누는 숫자가 0일때 예외처리")
    @Test
    void invalidDivideCalculationTest() {
        //given
        int operand1 = 100, operand2 = 0;

        //when
        assertThatThrownBy(() ->
                Operator.DIVIDE.calculate(operand1, operand2))
                //then
                .isInstanceOf(StringException.class)
                .hasMessageContaining(StringException.INVALID_DIVIDE_VALUE);
    }
}
