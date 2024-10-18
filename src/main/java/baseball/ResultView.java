package baseball;

public class ResultView {
    public static void printResult(Result result) {
        if (result.getStrike() == 0 && result.getBall() == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(result.getBall() + "볼 " + result.getStrike() + "스트라이크");
        }
    }
}
