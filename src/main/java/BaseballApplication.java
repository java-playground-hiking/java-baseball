import study.BaseballGame;
import study.BaseballScore;

public class BaseballApplication {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        BaseballScore score = baseballGame.playGame("123");

        System.out.println(score.printScore());
    }
}
