package baseball.domain.count;

public enum Count {

    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫띵");

    public String description;

    Count(String description) {
        this.description = description;
    }
}
