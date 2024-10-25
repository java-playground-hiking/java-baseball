package study.model;

public class BaseballScore {
    private int strike;
    private int ball;

    public BaseballScore(){
        this.strike = 0;
        this.ball = 0;
    }

    public void addStrike(){
        this.strike++;
    }

    public void addBall() {
        this.ball++;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }
}
