package study;

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

    public String printScore() {
        StringBuilder sb = new StringBuilder();

        if (ball != 0){
            sb.append(this.ball).append("볼");
        }
        if (ball != 0 && strike != 0){
            sb.append(" ");
        }
        if (strike != 0){
            sb.append(this.strike).append("스트라이크");
        }
        if (ball == 0 && strike == 0){
            sb.append("낫싱");
        }

        return sb.toString();
    }


    public boolean isThreeStrike() {
        return strike == 3;
    }
}
