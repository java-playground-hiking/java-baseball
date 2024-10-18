package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private List<Integer> answer;

    public Game() {
        this.answer = generateRandomNumbers();
    }

    public Game(List<Integer> answer) {
        this.answer = answer;
    }

    public void start() {
        boolean isCorrect = false;
        while (!isCorrect) {
            try {
                List<Integer> guess = InputView.getUserInput();
                Result result = checkGuess(guess);
                ResultView.printResult(result);
                isCorrect = result.isCorrect();
            } catch (IllegalArgumentException e) {
                System.out.println("입력 오류: " + e.getMessage());
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        while (numbers.size() < 3) {
            int num = random.nextInt(9) + 1;
            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }
        return numbers;
    }

    public Result checkGuess(List<Integer> guess) {
        validateInput(guess);

        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (guess.get(i).equals(answer.get(i))) {
                strike++;
            }
            if (!guess.get(i).equals(answer.get(i)) && answer.contains(guess.get(i))) {
                ball++;
            }
        }
        return new Result(strike, ball);
    }

    private void validateInput(List<Integer> guess) {
        if (guess.size() != 3) {
            throw new IllegalArgumentException("숫자 3개를 정확히 입력해야 합니다.");
        }
        if (guess.stream().distinct().count() != 3) {
            throw new IllegalArgumentException("각 숫자는 중복되지 않아야 합니다.");
        }
        if (!guess.stream().allMatch(n -> n >= 1 && n <= 9)) {
            throw new IllegalArgumentException("모든 숫자는 1에서 9 사이여야 합니다.");
        }
    }

    public List<Integer> getAnswer() {
        return new ArrayList<>(answer);
    }
}
