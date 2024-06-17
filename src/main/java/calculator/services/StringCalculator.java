package calculator.services;


import calculator.utils.Operator;
import calculator.utils.StringExpression;

public class StringCalculator {

    /**
     * 문자열 수식 계산기
     * @param expressionValues `Array`로 변환 된 문자열 수식어
     * @return 연산 결과, 우선 순위 없이 왼쪽 부터 연산 수행
     */

    public int calculate(String[] expressionValues) {
        if (!StringExpression.isNumeric(expressionValues[0])) {
            throw new IllegalArgumentException("Invalid math expression must be start with number");
        }

        String op = "";
        int expresionResult = Integer.parseInt(expressionValues[0]);
        int operandLast = 0;

        // NOTE: 짝수 인덱스는 항상 피연산자며, 홀수 인덱스는 항상 연산자가 되어야 정상 수식의 패턴이 됨
        for (int i = 0; i < expressionValues.length - 2; i += 2) {
            String expressionNumber = expressionValues[i + 2];

            if (StringExpression.isNumeric(expressionNumber)) {
                operandLast = Integer.parseInt(expressionValues[i + 2]);
            }

            op = expressionValues[i + 1];
            // NOTE: 연산 결과를 첫번째 인자로 넘기기 위해 `operandFirst` 변수에 반환 값을 할당
            expresionResult = Operator.getOperator(op).apply(expresionResult, operandLast);
        }
        return expresionResult;
    }
}

