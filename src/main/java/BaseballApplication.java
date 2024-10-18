import study.Baseball;
import study.BaseballGame;
import study.BaseballScanner;

public class BaseballApplication {
    public static void main(String[] args){
        BaseballScanner scanner = new BaseballScanner();
        Baseball baseball = new Baseball();
        BaseballGame game = new BaseballGame(scanner, baseball);

        do {
            String result = game.playGame();
            System.out.println(result);

        } while(game.isReplay());

        System.out.println(game.endGame());
    }
}
