package calculator;

import calculator.utils.StringExpression;
import calculator.presentation.User;
import calculator.services.StringCalculator;

public class Main {

    public static void main(String[] args) {
        StringCalculator service = new StringCalculator();
        String input = User.input();
        System.out.println("input = " + input);

        String[] expressionValues = StringExpression.convertExpressionArraysByBlank(input);
        int result = service.calculate(expressionValues);
        System.out.println("result = " + result);
    }

}
