package baseball.matcher;

import java.util.List;

//숫자가 위치가 일치 하는지 비교
public class PositionMatcher {

    public boolean isPositionMatching(List<Integer> answer, int guessedNumber, int index) {
        return answer.get(index) == guessedNumber;
    }
}
