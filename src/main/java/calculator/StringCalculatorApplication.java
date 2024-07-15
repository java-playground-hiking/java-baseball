package calculator;

import calculator.model.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class StringCalculatorApplication {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator(new InputView(), new OutputView());
        stringCalculator.run();
    }
}
