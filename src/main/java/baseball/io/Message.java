package baseball.io;

public class Message {

    public static final String RESTART_PROMPT = "게임을 새로 시작은 1, 종료 2를 입력하세요.";
    public static final String GAME_END = "게임 종료";
    public static final String GAME_COMPLETE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료한다요~~~~~~~~~";

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
