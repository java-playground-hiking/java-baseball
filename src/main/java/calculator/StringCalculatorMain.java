package calculator;

public class StringCalculatorMain {

    public static void main(String[] args) {
        CalculatorService service = new CalculatorService();
        String input = CalculatorUser.input();
        System.out.println("input = " + input);

        String[] expressionValues = service.convertExpressionArrays(input);
        int result = service.calculate(expressionValues);
        System.out.println("result = " + result);
    }

}
