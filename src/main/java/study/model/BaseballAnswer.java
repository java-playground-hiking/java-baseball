package study.model;

import study.utils.BaseballUtils;

import java.util.ArrayList;
import java.util.List;

public class BaseballAnswer {
    private static final int NUMBER_OF_ANSWER = 3;
    private final List<Integer> answer;

    public BaseballAnswer(){
        this.answer = new ArrayList<>();
        createAnswer();
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void createAnswer() {
        while(answer.size() < NUMBER_OF_ANSWER){
            addUniqueNumber(answer);
        }

    }

    public void addUniqueNumber(List<Integer> answer) {
        int num = BaseballUtils.getRandomNumber();

        if (!answer.contains(num)){
            answer.add(num);
        }
    }
}
