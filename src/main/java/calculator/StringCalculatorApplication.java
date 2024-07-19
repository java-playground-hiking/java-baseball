package calculator;

import calculator.model.StringCalculator;
import calculator.model.StringParser;
import calculator.utils.StringExceptionHandler;
import calculator.view.InputView;

public class StringCalculatorApplication {
    public static void main(String[] args) {
        String[] expressionTokens = new StringParser(new InputView().getInputString()).parse(); //ok
        StringExceptionHandler stringExceptionHandler = new StringExceptionHandler(expressionTokens).validate();
        StringCalculator stringCalculator = new StringCalculator(stringExceptionHandler);
        stringCalculator.run();
    }
}
