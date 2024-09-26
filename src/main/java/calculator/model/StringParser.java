package calculator.model;

import calculator.utils.StringException;

public class StringParser {
    private static final String DELIMITER = " ";
    private final String expression;

    public StringParser(String inputString) {
        this.expression = inputString;
    }

    public String[] parse() {
        if (isNullOrBlank(expression)) {
            throw new StringException(StringException.NULL_STRING_EXCEPTION);
        }
        return expression.split(DELIMITER);
    }

    private boolean isNullOrBlank(String expression) {
        return expression == null || expression.isBlank();
    }
}

