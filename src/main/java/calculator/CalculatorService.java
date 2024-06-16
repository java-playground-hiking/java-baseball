package calculator;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class CalculatorService {

    // NOTE: 연산자 옵션
    public static final Map<String, BiFunction<Integer, Integer, Integer>> operator = new HashMap<>();
    static {
        operator.put("+", (x, y) -> x + y);
        operator.put("-", (x, y) -> x - y);
        operator.put("*", (x, y) -> x * y);
        operator.put("/", (x, y) -> {
            if (y == 0) {
                throw new ArithmeticException("can't division by zero");
            }
            return x / y;
        });
    }

    /**
     * 문자열 수식을 배열로 변환
     * @param mathExpression 문자열 수식
     * @return 문자열 수식을 공백을 기준으로 `split` 한 배열 반환 값
     */
    public String[] convertExpressionArrays(String mathExpression) {
        return mathExpression.split(" ");
    }

    /**
     * 문자로 이루어진 데이터를 받아 숫자 여부 확인
     * @param string 문자열 데이터
     * @return boolean - true: 숫자, false: 문자
     */
    public boolean isNumeric(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     *  계산기 서비스에서 지정한 연산자 여부 확인
     * @param string 문자열 데이터
     * @return boolean - true: 연산자, false: 일반 문자, 그 외 `IllegalArgumentException` 익셉션 발생
     */
    public boolean isOperator(String string) {
        List<String> keys = new ArrayList<>(operator.keySet());

        if (keys.contains(string)) {
            return true;
        }
        throw new IllegalArgumentException("Input the invalid operator");
    }

    /**
     * 문자열 수식 계산기
     * @param expressionValues `Array`로 변환 된 문자열 수식어
     * @return 연산 결과, 우선 순위 없이 왼쪽 부터 연산 수행
     */
    public int calculate(String[] expressionValues) {
        if (!isNumeric(expressionValues[0])) {
            throw new IllegalArgumentException("Invalid math expression must be start with number");
        }

        String op = "";
        int expresionResult = Integer.parseInt(expressionValues[0]);
        int operandLast = 0;

        // NOTE: 짝수 인덱스는 항상 피연산자며, 홀수 인덱스는 항상 연산자가 되어야 정상 수식의 패턴이 됨
        for (int i = 0; i < expressionValues.length - 2; i += 2) {
            String expressionNumber = expressionValues[i + 2];

            if (isNumeric(expressionNumber)) {
                operandLast = Integer.parseInt(expressionValues[i + 2]);
            }

            if (isOperator(expressionValues[i + 1])) {
                op = expressionValues[i + 1];
                // NOTE: 연산 결과를 첫번째 인자로 넘기기 위해 `operandFirst` 변수에 반환 값을 할당
                expresionResult = operator.get(op).apply(expresionResult, operandLast);
            }
        }
        return expresionResult;
    }
}

