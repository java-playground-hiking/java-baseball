package baseball;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        while (true) {
            game.start();
            System.out.println("게임을 새로 시작은 1, 종료 2를 입력하세요.");
            String choice = scanner.nextLine().trim();
            if (!choice.equals("1")) {
                System.out.println("게임 종료");
                break;
            }
        }
    }
}
