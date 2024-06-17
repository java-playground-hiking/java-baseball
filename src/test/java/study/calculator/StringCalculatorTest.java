package study.calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import calculator.services.StringCalculator;
import calculator.utils.Operator;
import calculator.utils.StringExpression;
import java.util.function.BiFunction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringCalculatorTest {

    String stringExpression;
    static StringCalculator service;

    /**
     * ** 테스트 관점 ** 1. 유틸성 클래스의 정적 메서드 정상 케이스, 예외 케이스 검증 2. 핵심 도메인의 비즈니스 로직 결과 검증
     */
    @BeforeAll
    static void serviceInit() {
        service = new StringCalculator();
    }

    @BeforeEach
    void setUp() {
        stringExpression = "2 + 3 * 4 / 2";
    }

    @ParameterizedTest
    @DisplayName("`StringExpression` 숫자 여부 검증")
    @CsvSource(value = {"1:true", "+:false"}, delimiter = ':')
    void 숫자_여부_검증(String expectedNumericValue, boolean expectedResult) {
        // Given
        String stringExpressionValue = expectedNumericValue;
        boolean expect = expectedResult;

        // When
        boolean result = StringExpression.isNumeric(stringExpressionValue);

        // Then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("`StringExpression` 공백 기준으로 문자열 분리 검증")
    void 공백을_기준으로_문자열_분리() {
        // Given
        String fixture = stringExpression;

        // When
        String[] expressionArray = StringExpression.convertExpressionArraysByBlank(
                stringExpression);

        // Then
        assertThat(expressionArray).containsExactly("2", "+", "3", "*", "4", "/", "2");
    }

    @Test
    @DisplayName("`StringExpression` 공백 기준으로 문자열 분리시 예외 케이스 검증")
    void 공백을_기준으로_문자열_분리_예외케이스() {
        // Given
        String fixture = "2 + 3*4 /2";

        // When
        assertThatThrownBy(() -> {
            StringExpression.convertExpressionArraysByBlank(fixture);
        })
                // Then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Expression must be seperated by a space");
    }

    @ParameterizedTest
    @DisplayName("`Operator` 연산자 정상 케이스 검증")
    @CsvSource({"+,1,1,2", "-,1,1,0", "*,4,2,8", "/, 2,2,1"})
    void 연산자_정상_검증(String op, int num1, int num2, int expected) {
        // Given
        BiFunction<Integer, Integer, Integer> operator = Operator.getOperator(op);

        // When
        int result = operator.apply(num1, num2);

        // Then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("`Operator` 연산자 나눗셈 예외 케이스 검증")
    @CsvSource({"0,1", "1,0"})
    void 연산자_나눗셈_예외_검증(int num1, int num2) {
        // Given
        String op = "/";

        // When
        assertThatThrownBy(() -> {
            Operator.getOperator(op).apply(num1, num2);
        })      // Then
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("can't division by zero");
    }

    @Test
    @DisplayName("`Operator` 잘못된 연산자 검증")
    void 잘못된_연산자_예외_검증() {
        // Given
        String op = "^";
        int num1 = 10;
        int num2 = 2;

        // When
        assertThatThrownBy(() -> {
            Operator.getOperator(op).apply(num1, num2);
        })      // Then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not matching operator symbol");
    }

    @Test
    @DisplayName("`StingCalculator` 문자열 연산 검증")
    void 문자열_연산_검증() {
        // Given
        String[] fixture = StringExpression.convertExpressionArraysByBlank(stringExpression);

        // When
        int result = service.calculate(fixture);

        // Then
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("`StringCalculator` 문자열 수식의 첫 번째 피연산사자가 숫자가 아닌 경우 예외 검증")
    void 문자열_연산_수식_예외_케이스() {
        // Given
        String invalidExpression = "+ 1 + 5";
        String[] fixture = StringExpression.convertExpressionArraysByBlank(invalidExpression);

        // When
        assertThatThrownBy(() -> {
            service.calculate(fixture);
        })
                // Then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid math expression must be start with number");

    }
}
