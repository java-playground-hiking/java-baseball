package study;

import java.util.*;

public class Baseball {


    private static final int PLAY_ROUND = 3;
    private final List<Integer> answer;
    private final BaseballScore score;

    public Baseball(BaseballScore score, BaseballAnswer baseballAnswer){
        this.score = score;
        this.answer = baseballAnswer.getAnswer();
    }

    public BaseballScore play(List<Integer> userInput) {
        System.out.println(answer.toString());
        for(int i=0; i<PLAY_ROUND; i++){
            calculateScore(i, userInput.get(i));
        }

        return score;
    }

    public void calculateScore(int index, int input){
        boolean isStrike = answer.get(index).equals(input);

        if (isStrike){
            score.addStrike();
        }
        if (!isStrike && answer.contains(input)){
            score.addBall();
        }
    }

}
