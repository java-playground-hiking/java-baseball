package baseball.controller;

import baseball.game.Game;
import baseball.io.Message;

import java.util.Scanner;

public class GameController {
    private final Game game;
    private final Scanner scanner;

    // 의존성 주입: 외부에서 객체를 주입받도록 생성자 수정
    public GameController(Game game, Scanner scanner) {
        this.game = game;
        this.scanner = scanner;
    }

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            game.start();
            isRunning = promptRestart();
        }
        Message.printMessage(Message.GAME_END);
    }

    private boolean promptRestart() {
        Message.printMessage(Message.RESTART_PROMPT);
        String choice = scanner.nextLine().trim();
        return choice.equals("1");
    }
}
