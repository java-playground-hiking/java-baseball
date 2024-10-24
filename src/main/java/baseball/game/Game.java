package baseball.game;

import baseball.validation.Validator;
import baseball.io.InputView;
import baseball.io.ResultView;
import baseball.model.Result;

import java.util.List;

public class Game {
    private List<Integer> answer;
    private Validator validator;
    private RandomNumberGenerator randomNumberGenerator;
    private GuessChecker guessChecker;

    public Game() {
        this.randomNumberGenerator = new RandomNumberGenerator();
        this.answer = randomNumberGenerator.generate();
        this.validator = new Validator();
        this.guessChecker = new GuessChecker(answer);
    }

    public Game(List<Integer> answer) {
        this.answer = answer;
        this.validator = new Validator();
        this.guessChecker = new GuessChecker(answer);
    }

    // 주석으로 바꾸면 RED
    public List<Integer> getAnswer() {
        return answer;
    }
    // 주석으로 바꾸면 RED
    public Result checkGuess(List<Integer> guess) {
        validator.validate(guess);  // 유효성 검사
        return guessChecker.check(guess);  // 스트라이크와 볼 계산 후 Result 반환
    }

    public void start() {
        boolean isCorrect = false;
        while (!isCorrect) {
            try {
                List<Integer> guess = InputView.getUserInput();
                validator.validate(guess);

                // GuessChecker로부터 얻는 결과를 StrikeAndBall로 변경
                Result strikeAndBall = guessChecker.check(guess);

                // StrikeAndBall 객체를 ResultView로 전달
                ResultView.printResult(strikeAndBall);

                // 스트라이크가 3개일 때 isCorrect를 true로 설정
                isCorrect = strikeAndBall.getStrike() == 3;
            } catch (IllegalArgumentException e) {
                System.out.println("입력 오류: " + e.getMessage());
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
