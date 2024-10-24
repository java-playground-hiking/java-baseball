package study;

import java.util.List;

public class BaseballGame {

    public BaseballScore playGame(String number) {
        BaseballGenerator generator = new BaseballGenerator();
        List<Integer> userInput = generator.createUserInputList(number);
        List<Integer> answer = generator.createAnswer();

        Baseball baseball = new Baseball(new BaseballScore(), answer);
        return baseball.play(userInput);

    }
}
