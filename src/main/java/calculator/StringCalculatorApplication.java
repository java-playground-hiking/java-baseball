package calculator;

import calculator.model.StringCalculator;
import calculator.model.StringParser;
import calculator.utils.StringExceptionHandler;
import calculator.view.InputView;
import calculator.view.OutputView;

public class StringCalculatorApplication {
    public static void main(String[] args) {
        String[] expressionTokens = new StringParser(new InputView().getInputString()).parse();
        StringExceptionHandler stringExceptionHandler = new StringExceptionHandler(expressionTokens).validate();
        int calculationResult = new StringCalculator(stringExceptionHandler).calculate();
        new OutputView().printCalculationResult(calculationResult);
    }
}
