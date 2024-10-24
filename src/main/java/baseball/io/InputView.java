package baseball.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static List<Integer> getUserInput() {
        while (true) {
            try {
                String input = getInputFromUser();
                validateRawInput(input);
                List<Integer> numbers = extractNumbers(input);
                validateNumbers(numbers);
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR : " + e.getMessage());
            }
        }
    }

    private static String getInputFromUser() {
        System.out.print("숫자를 입력해 주세요(1에서 9 사이의 숫자 3개): ");
        return scanner.nextLine().trim();
    }

    static void validateRawInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다. 숫자 3개를 입력하세요.");
        }
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값은 정확히 3자리여야 합니다.");
        }
        if (!input.matches("[1-9]+")) {  // 숫자가 아닌 문자나 특수기호를 처리
            throw new IllegalArgumentException("입력값에는 1에서 9 사이의 숫자만 포함되어야 합니다.");
        }
    }

    static List<Integer> extractNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();

        // 입력에서 숫자만 추출하고 공백은 무시
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                int num = Character.getNumericValue(c);
                numbers.add(num);
            }
        }

        return numbers;
    }

    static void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("숫자 3개를 정확히 입력해야 합니다.");
        }
        if (numbers.stream().distinct().count() != 3) {
            throw new IllegalArgumentException("각 숫자는 중복되지 않아야 합니다.");
        }
        if (!numbers.stream().allMatch(n -> n >= 1 && n <= 9)) {
            throw new IllegalArgumentException("모든 숫자는 1에서 9 사이여야 합니다.");
        }
    }
}
