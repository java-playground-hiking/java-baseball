package baseball.game;

import baseball.checker.BallChecker;
import baseball.checker.StrikeChecker;
import baseball.model.Result;
import baseball.model.Result;

import java.util.List;

class GuessChecker {
    private List<Integer> answer;
    private StrikeChecker strikeChecker;
    private BallChecker ballChecker;

    public GuessChecker(List<Integer> answer) {
        this.answer = answer;
        this.strikeChecker = new StrikeChecker();
        this.ballChecker = new BallChecker();
    }

    public Result check(List<Integer> guess) {
        int strike = strikeChecker.countStrikes(guess, answer);
        int ball = ballChecker.countBalls(guess, answer);
        return new Result(strike, ball);
    }
}
