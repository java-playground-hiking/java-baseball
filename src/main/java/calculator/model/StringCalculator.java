package calculator.model;

import calculator.utils.StringExpression;

public class StringCalculator {
    private final StringExpression stringExpression;

    public StringCalculator(StringExpression stringExpression) {
        this.stringExpression = stringExpression;
    }

    public int calculate() {
        int expressionLength = stringExpression.getExpressionLength();
        int preNumber = stringExpression.getNumberByIndex(0);
        for (int i = 1; i < expressionLength; i += 2) {
            Operator operator = stringExpression.getOperatorByIndex(i);
            int afterNumber = stringExpression.getNumberByIndex(i + 1);
            preNumber = operator.calculate(preNumber, afterNumber);
        }
        return preNumber;
    }
}
