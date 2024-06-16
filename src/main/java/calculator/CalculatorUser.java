package calculator;

import java.util.Scanner;

public class CalculatorUser {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * 사용자 입력 값 반환
     * @return String - 사용자에게 입력 받은 값
     */
    static String input() {
        System.out.println("계산 할 수식을 입력 하세요.");
        System.out.print("> ");
        return scanner.nextLine();
    }
}
