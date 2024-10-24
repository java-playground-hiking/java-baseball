package study;

import java.util.ArrayList;
import java.util.List;

public class BaseballAnswer {
    private static final int LIST_SIZE = 3;
    private final List<Integer> answer;

    public BaseballAnswer(){
        this.answer = new ArrayList<>();
        createAnswer();
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void createAnswer() {
        while(answer.size() < LIST_SIZE){
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
