package calculator.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_STRING_MESSAGE = "계산하고 싶은 수식을 입력하세요: ";

    public InputView() {
    }

    public String getInputString() {
        System.out.print(INPUT_STRING_MESSAGE);
        return scanner.nextLine();
    }
}
