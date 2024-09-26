package calculator.model;

import calculator.utils.StringException;
import java.util.Arrays;

public enum Operator {
    PLUS("+") {
        @Override
        public int calculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    },
    MINUS("-") {
        @Override
        public int calculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    },
    DIVIDE("/") {
        @Override
        public int calculate(int operand1, int operand2) {
            try {
                return operand1 / operand2;
            } catch (ArithmeticException e) {
                throw new StringException(StringException.INVALID_DIVIDE_VALUE);
            }
        }
    },
    MULTIPLY("*") {
        @Override
        public int calculate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    };

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public static Operator findOperator(String operator) {
        return Arrays.stream(values())
                .filter(value -> value.operator.equals(operator))
                .findAny()
                .orElseThrow(() -> new StringException(StringException.INVALID_OPERATOR));
    }

    public abstract int calculate(int operand1, int operand2);
}
