package calculator.utils;

import calculator.model.Operator;

public class StringExpression {
    private static final int MINIMUM_TOKEN_COUNT = 3;
    private final String[] expressionTokens;

    public StringExpression(String[] expressionTokens) {
        this.expressionTokens = expressionTokens;
    }

    public StringExpression validate() {
        validateExpressionTokenCount(expressionTokens);
        return new StringExpression(expressionTokens);
    }

    public int getExpressionLength() {
        return expressionTokens.length;
    }

    public int getNumberByIndex(int index) {
        try {
            return Integer.parseInt(expressionTokens[index]);
        } catch (NumberFormatException e) {
            throw new StringException(StringException.INVALID_LOCATION);
        } catch (IndexOutOfBoundsException e) {
            throw new StringException(StringException.INDEX_OUT_OF_BOUND);
        }
    }

    public Operator getOperatorByIndex(int index) {
        try {
            return Operator.findOperator(expressionTokens[index]);
        } catch (IndexOutOfBoundsException e) {
            throw new StringException(StringException.INDEX_OUT_OF_BOUND);
        }
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
