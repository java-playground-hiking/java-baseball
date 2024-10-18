package study;

import java.util.*;

public class Baseball {
    private final List<Integer> answerList;

    public Baseball(){
        answerList = getAnswer();
    }

    public Baseball(List<Integer> answerList) {
        this.answerList = answerList;
    }

    public BaseballScore play(List<Integer> userInput){
        BaseballScore score = new BaseballScore();

        for (int i=0; i<userInput.size(); i++){
            int index = answerList.indexOf(userInput.get(i));
            score.addScore(index, i);
        }

        return score;
    }

    public List<Integer> getAnswer() {
        List<Integer> answers = new ArrayList<>();
        Random random = new Random();

        while(answers.size() < 3){
            int num = random.nextInt(9)+1;
            answers = addUniqueNumber(num, answers);
        }

        return answers;

    }

    public List<Integer> addUniqueNumber(int num, List<Integer> answers){
        if (!answers.contains(num)){
            answers.add(num);
        }

        return answers;
    }

}
