package study.calculator;

import calculator.model.Operator;
import calculator.utils.StringException;
import calculator.utils.StringExpression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringExpressionTest {
    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of((Object) new String[]{"2", "*"}),
                Arguments.of((Object) new String[]{"2", "*", "67", "%"})
        );
    }

    @DisplayName("문자열 토큰 개수가 3이상이고 홀수인 경우 테스트")
    @Test
    void validExpressionTokenCountTest() {
        //given
        String[] expressionTokens = {"2", "*", "1", "/", "8"};
        StringExpression stringExpression = new StringExpression(expressionTokens);

        //when
        StringExpression returnExpression = stringExpression.validate();

        //then
        assertThat(returnExpression).isNotEqualTo(stringExpression);
    }

    @DisplayName("문자열 토큰 개수가 2이하 혹은 짝수인 경우 테스트")
    @ParameterizedTest
    @MethodSource("generateData")
    void invalidExpressionTokenCountTest1(String[] tokens) {
        //given
        StringExpression stringExpression = new StringExpression(tokens);

        //when
        assertThatThrownBy(stringExpression::validate)
                //then
                .isInstanceOf(StringException.class)
                .hasMessageContaining(StringException.INVALID_STRING_TOKEN_COUNT);
    }

    @DisplayName("문자열 토큰 숫자로 변환 테스트")
    @Test
    void changeCharToNumberTest() {
        //given
        String[] expressionTokens = {"2", "*", "67", "%"};
        StringExpression stringExpression = new StringExpression(expressionTokens);

        //when
        int number = stringExpression.getNumberByIndex(0);

        //then
        assertThat(number).isEqualTo(2);
    }

    @DisplayName("문자열 토큰 숫자가 아닌 경우 예외처리")
    @Test
    void invalidExpressionNumberTest() {
        //given
        String[] expressionTokens = {"2", "*", "67", "%"};
        StringExpression stringExpression = new StringExpression(expressionTokens);

        //when
        assertThatThrownBy(() -> stringExpression.getNumberByIndex(1))
                //then
                .isInstanceOf(StringException.class)
                .hasMessageContaining(StringException.INVALID_LOCATION);
    }

    @DisplayName("문자열 숫자 토큰 반환 메서드 인덱스 범위 초과 예외처리")
    @Test
    void expressionNumberTokenOutOfIndex() {
        //given
        String[] expressionTokens = {"2", "*", "67", "%"};
        StringExpression stringExpression = new StringExpression(expressionTokens);

        //when
        assertThatThrownBy(() -> stringExpression.getNumberByIndex(4))
                //then
                .isInstanceOf(StringException.class)
                .hasMessageContaining(StringException.INDEX_OUT_OF_BOUND);
    }

    @DisplayName("문자열 토큰 올바른 연산자 확인 테스트")
    @Test
    void validExpressionTokenOperatorTest() {
        //given
        String[] expressionTokens = {"2", "*", "67", "%"};
        StringExpression stringExpression = new StringExpression(expressionTokens);

        //when
        Operator operator = stringExpression.getOperatorByIndex(1);

        //then
        assertThat(operator).isEqualTo(Operator.MULTIPLY);
    }

    @DisplayName("문자열 토큰이 올바른 연산자가 아닌 경우 예외처리")
    @Test
    void invalidExpressionTokenOperatorTest() {
        //given
        String[] expressionTokens = {"2", "&", "67", "%"};
        StringExpression stringExpression = new StringExpression(expressionTokens);

        //when
        assertThatThrownBy(() -> stringExpression.getOperatorByIndex(1))
                .isInstanceOf(StringException.class)
                .hasMessageContaining(StringException.INVALID_OPERATOR);
    }

    @DisplayName("문자열 연산자 토큰 반환메서드 인덱스 범위 초과 예외처리")
    @Test
    void expressionOperatorTokenOutOfIndex() {
        //given
        String[] expressionTokens = {"2", "*", "67", "%"};
        StringExpression stringExpression = new StringExpression(expressionTokens);

        //when
        assertThatThrownBy(() -> stringExpression.getOperatorByIndex(4))
                //then
                .isInstanceOf(StringException.class)
                .hasMessageContaining(StringException.INDEX_OUT_OF_BOUND);
    }

    @DisplayName("문자열 길이 반환 테스트")
    @Test
    void getExpressionLengthTest() {
        //given
        String[] expressionTokens = {"2", "*", "1", "/", "8", "*", "7"};
        StringExpression stringExpression = new StringExpression(expressionTokens);

        //when
        int length = stringExpression.getExpressionLength();

        //then
        assertThat(length).isEqualTo(7);
    }
}
