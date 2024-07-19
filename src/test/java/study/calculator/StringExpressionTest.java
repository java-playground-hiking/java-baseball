package study.calculator;

import calculator.utils.StringExpression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringExpressionTest {

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
}
