package study;

import java.util.*;

public class Baseball {

    private static final int PLAY_ROUND = 3;
    private final List<Integer> answer;
    private final BaseballScore score;

    public Baseball(BaseballScore score, List<Integer> answer){
        this.score = score;
        this.answer = answer;
    }

    public BaseballScore play(List<Integer> userInput) {
        System.out.println(answer.toString());
        for(int i=0; i<PLAY_ROUND; i++){
            checkAnswer(i, userInput.get(i));
        }

        return score;
    }

    public void checkAnswer(int i, int input){
        boolean sameIndex = answer.get(i).equals(input);

        if (sameIndex){
            score.addStrike();
        }
        if (!sameIndex && answer.contains(input)){
            score.addBall();
        }
    }










}
