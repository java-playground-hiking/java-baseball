package study.view;

import study.model.BaseballScore;

public class ResultView {
    public String printScore(BaseballScore score) {
        StringBuilder sb = new StringBuilder();

        int ball = score.getBall();
        int strike = score.getStrike();

        if (ball != 0){
            sb.append(ball).append("볼");
        }
        if (ball != 0 && strike != 0){
            sb.append(" ");
        }
        if (strike != 0){
            sb.append(strike).append("스트라이크");
        }
        if (ball == 0 && strike == 0){
            sb.append("낫싱");
        }

        return sb.toString();
    }
}
