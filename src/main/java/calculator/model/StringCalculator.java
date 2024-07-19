package calculator.model;

import calculator.utils.StringExceptionHandler;

public class StringCalculator {
    private final StringExceptionHandler stringExceptionHandler;

    public StringCalculator(StringExceptionHandler stringExceptionHandler) {
        this.stringExceptionHandler = stringExceptionHandler;
    }

    public int calculate() {
        int expressionLength = stringExceptionHandler.getExpressionLength();
        int preNumber = stringExceptionHandler.getNumberByIndex(0);
        for (int i = 1; i < expressionLength; i += 2) {
            Operator operator = stringExceptionHandler.getOperatorByIndex(i);
            int afterNumber = stringExceptionHandler.getNumberByIndex(i + 1);
            preNumber = operator.calculate(preNumber, afterNumber);
        }
        return preNumber;
    }
}
