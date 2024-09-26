import java.util.NoSuchElementException;
import java.util.Scanner;

// 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
//문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정
public class StringCalculator {

    public int execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력하세요: ");
        String input;
        try {
            input = scanner.nextLine();
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("공백은 입력할 수 없습니다.");
        }
        scanner.close();
        String[] splitInput = input.split(" ");

        return throwMethod(splitInput);
    }

    public int throwMethod(String[] splitInput){
        try {
            return parseInput(splitInput);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("입력이 잘못되었습니다.");
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자 자리에 다른 문자를 입력했거나 띄워쓰기가 잘못되었습니다.");
        }
    }

    public int parseInput(String[] values) {
        int result = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            result = calculate(result, values[i], Integer.parseInt(values[i + 1]));
        }
        return result;
    }

    public int calculate(int first, String operator, int second) {
        switch (operator) {
            case "+":
                return add(first, second);
            case "-":
                return subtract(first, second);
            case "*":
                return multiply(first, second);
            case "/":
                return divide(first, second);
        }
        throw new IllegalArgumentException("연산자 자리에 확인되지 않은 문자가 들어왔습니다. 연산자 : " + operator);
    }

    int add(int first, int second) {
        return first + second;
    }

    int subtract(int first, int second) {
        return first - second;
    }

    int multiply(int first, int second) {
        return first * second;
    }

    int divide(int first, int second) {
        try {
            return first / second;
        } catch (ArithmeticException e) {
            System.out.println("0으로 나누는 것은 불가능 합니다");
        }
        return 0;
    }

}
