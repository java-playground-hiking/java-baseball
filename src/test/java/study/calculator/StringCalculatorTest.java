package study.calculator;

import calculator.model.StringCalculator;
import calculator.utils.StringException;
import calculator.utils.StringExpression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.stream.Stream;

public class StringCalculatorTest {
    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(new String[]{"2", "*", "4", "-", "45", "+", "3", "/", "7"}, -4),
                Arguments.of(new String[]{"10", "*", "2", "-", "1", "+", "55", "/", "10"}, 7),
                Arguments.of(new String[]{"5", "*", "7", "-", "10", "+", "346", "/", "5"}, 74)
        );
    }

    @DisplayName("모든 4가지 연산자에 대해 계산 테스트")
    @ParameterizedTest
    @MethodSource("generateData")
    void calculateAllOperatorTest(String[] tokens, int answer) {
        //given
        StringExpression stringExpression = new StringExpression(tokens);
        StringCalculator stringCalculator = new StringCalculator(stringExpression);

        //when
        int result = stringCalculator.calculate();

        //then
        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("문자열 토큰 숫자자리에 문자가 온 경우 예외처리")
    @Test
    void invalidTokenLocationTest() {
        //given
        String[] expressionTokens = {"2", "*", "+", "/", "8"};
        StringExpression stringExpression = new StringExpression(expressionTokens);
        StringCalculator stringCalculator = new StringCalculator(stringExpression);

        //when
        assertThatThrownBy(stringCalculator::calculate)
                //then
                .isInstanceOf(StringException.class)
                .hasMessageContaining(StringException.INVALID_LOCATION);
    }

    @DisplayName("연산자 자리에 잘못된 연산자가 온 경우 예외처리")
    @Test
    void invalidTokenOperatorTest() {
        //given
        String[] expressionTokens = {"2", "*", "20", "$", "8"};
        StringExpression stringExpression = new StringExpression(expressionTokens);
        StringCalculator stringCalculator = new StringCalculator(stringExpression);

        //when
        assertThatThrownBy(stringCalculator::calculate)
                //then
                .isInstanceOf(StringException.class)
                .hasMessageContaining(StringException.INVALID_OPERATOR);
    }
}
