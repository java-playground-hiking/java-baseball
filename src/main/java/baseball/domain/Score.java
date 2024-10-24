package baseball.domain;

import baseball.domain.count.Count;
import baseball.domain.count.Counts;

public class Score {

    private final Counts counts;

    private Score(Counts counts) {
        this.counts = counts;
    }

    public static Score from(Counts counts) {
        return new Score(counts);
    }

    public String getScreenMessage() {
        if (isStrikeCountGreaterThanZero() && isBallCountGreaterThanZero()) {
            return counts.getStrikeCount() + Count.STRIKE.description + " " + counts.getBallCount() + Count.BALL.description;
        }

        if (isStrikeCountGreaterThanZero()) {
            return counts.getStrikeCount() + Count.STRIKE.description;
        }

        if (isBallCountGreaterThanZero()) {
            return counts.getBallCount() + Count.BALL.description;
        }

        return Count.NOTHING.description;
    }

    private boolean isBallCountGreaterThanZero() {
        return counts.getBallCount() > 0;
    }

    private boolean isStrikeCountGreaterThanZero() {
        return counts.getStrikeCount() > 0;
    }

}
