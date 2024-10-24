package study;

import java.util.List;

public class BaseballGame {

    public BaseballScore playGame(String input) {
        BaseballUtils.checkLength(input);
        List<Integer> userInput = BaseballUtils.stringToIntegerList(input);

        Baseball baseball = new Baseball(new BaseballScore(), new BaseballAnswer());
        return baseball.play(userInput);

    }
}
