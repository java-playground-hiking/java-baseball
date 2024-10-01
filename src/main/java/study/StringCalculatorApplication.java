package study;

import study.model.CalculatorScanner;
import study.model.StringCalculator;

public class StringCalculatorApplication {
    public static void main(String[] args){
        CalculatorScanner scanner = new CalculatorScanner();
        String value = scanner.getInput();

        StringCalculator calculator = new StringCalculator();
        System.out.println("계산 결과 : " + calculator.calculate(value));
    }
}
