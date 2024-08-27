package domain;

import java.util.ArrayList;

public class Judgment {

    private final Score score = new Score();
    private final ArrayList<String> computerRandomNumbers;


    public Judgment(ArrayList<String> computerRandomNumbers) {
        this.computerRandomNumbers = computerRandomNumbers;
    }

    public Score judge(ArrayList<String> userInputNumbers) {
        newScore();

        for (int seq = 0; seq < userInputNumbers.size(); seq++) {
            scoreRecord(userInputNumbers, seq);
        }
        return score;
    }

    private void newScore() {
        score.clean();
    }

    private void scoreRecord(ArrayList<String> userInputNumbers, int arrayInPosition) {
        if (isStrike(userInputNumbers, arrayInPosition)) {
            score.strikeIncrement();
            return;
        }

        if (isBall(userInputNumbers, arrayInPosition)) {
            score.ballIncrement();
        }
    }

    private boolean isBall(ArrayList<String> userInputNumbers, int arrayInPosition) {
        return computerRandomNumbers.contains(userInputNumbers.get(arrayInPosition));
    }

    private boolean isStrike(ArrayList<String> userInputNumbers, int arrayInPosition) {
        return computerRandomNumbers.get(arrayInPosition).equals(userInputNumbers.get(arrayInPosition));
    }
}
