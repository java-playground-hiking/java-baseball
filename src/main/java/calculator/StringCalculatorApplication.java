package calculator;

import calculator.model.StringCalculator;
import calculator.model.StringParser;
import calculator.utils.StringExpression;
import calculator.view.InputView;
import calculator.view.OutputView;

public class StringCalculatorApplication {
    public static void main(String[] args) {
        String[] expressionTokens = new StringParser(new InputView().getInputString()).parse();
        StringExpression stringExpression = new StringExpression(expressionTokens).validate();
        int calculationResult = new StringCalculator(stringExpression).calculate();
        new OutputView().printCalculationResult(calculationResult);
    }
}
