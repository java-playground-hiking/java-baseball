package calculator.utils;

import calculator.model.Operator;

public class StringExceptionHandler {
    private static final int MINIMUM_TOKEN_COUNT = 3;
    private final String[] expressionTokens;

    public StringExceptionHandler(String[] expressionTokens) {
        this.expressionTokens = expressionTokens;
    }

    public StringExceptionHandler validate() {
        validateExpressionTokenCount(expressionTokens);
        return new StringExceptionHandler(expressionTokens);
    }

    public int getExpressionLength() {
        return expressionTokens.length;
    }

    public int getNumberByIndex(int index) {
        try {
            return Integer.parseInt(expressionTokens[index]);
        } catch (NumberFormatException e) {
            throw new StringException(StringException.INVALID_LOCATION);
        }
    }

    public Operator getOperatorByIndex(int index) {
        return Operator.findOperator(expressionTokens[index]);
    }

    private void validateExpressionTokenCount(String[] expressionTokens) {
        int tokenCount = expressionTokens.length;
        if (tokenCount < MINIMUM_TOKEN_COUNT || isEven(tokenCount)) {
            throw new StringException(StringException.INVALID_STRING_TOKEN_COUNT);
        }
    }

    private boolean isEven(int tokenCount) {
        return tokenCount % 2 == 0;
    }
}
