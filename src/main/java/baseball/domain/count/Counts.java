package baseball.domain.count;

import java.util.List;
import java.util.Objects;

public class Counts {

    private final long strikeCount;
    private final long ballCount;

    private Counts(List<Count> counts) {
        this.strikeCount = counts.stream().filter(count -> count == Count.STRIKE).count();
        this.ballCount = counts.stream().filter(count -> count == Count.BALL).count();
    }

    public static Counts of(Count first, Count second, Count third) {
        return new Counts(List.of(first, second, third));
    }

    public long getStrikeCount() {
        return strikeCount;
    }

    public long getBallCount() {
        return ballCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Counts counts = (Counts) o;
        return strikeCount == counts.strikeCount && ballCount == counts.ballCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strikeCount, ballCount);
    }
}
