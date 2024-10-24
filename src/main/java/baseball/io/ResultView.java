package baseball.io;

import baseball.model.Result;

public class ResultView {
    public static void printResult(Result strikeAndBall) {
        if (strikeAndBall.getStrike() == 0 && strikeAndBall.getBall() == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(strikeAndBall.getBall() + "볼 " + strikeAndBall.getStrike() + "스트라이크");
        }
    }
}
