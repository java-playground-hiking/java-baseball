package study;

import study.message.ErrorMessages;

import java.util.ArrayList;
import java.util.List;

public class BaseballGenerator {

    private static final int LIST_SIZE = 3;

    public List<Integer> createUserInputList(String input){
        input = input.replaceAll(" ", "");

        if (!BaseballUtils.checkLength(input)){
            throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT_LENGTH);
        }

        return BaseballUtils.stringToIntegerList(input);
    }

    public List<Integer> createAnswer() {
        List<Integer> answer = new ArrayList<>();

        while(answer.size() < LIST_SIZE){
            BaseballUtils.addUniqueNumber(answer);
        }

        return answer;
    }
}
