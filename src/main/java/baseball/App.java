package baseball;

import baseball.controller.GameController;
import baseball.game.Game;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        GameController gameController = new GameController(game, scanner);

        gameController.run();
    }
}
