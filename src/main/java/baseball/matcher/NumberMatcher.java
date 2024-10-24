package baseball.matcher;

import java.util.List;

// 숫자가 일치 하는지 비교 하고 싶은데....
public class NumberMatcher {

    public boolean isMatching(int guessedNumber, int answerNumber) {
        return guessedNumber == answerNumber;
    }
    // 숫자가 정답 리스트에 포함되어 있는지 확인하는 메서드
    public boolean isNumberMatching(List<Integer> answer, int guessedNumber) {
        return answer.contains(guessedNumber);
    }
}
