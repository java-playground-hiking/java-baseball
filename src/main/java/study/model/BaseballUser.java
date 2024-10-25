package study.model;

import study.utils.BaseballUtils;

import java.util.List;

public class BaseballUser {

    private final List<Integer> userInput;

    public BaseballUser(String input){
        InputValidate inputValidate = new InputValidate(input);
        this.userInput = inputValidate.validate();
    }

    public int getUserInputNumber(int index){
        return userInput.get(index);
    }

    public static class InputValidate {
        private final String input;

        public InputValidate(String input){
            this.input = BaseballUtils.removeSpaces(input);
        }

        public List<Integer> validate(){
            BaseballUtils.checkLength(input);
            return BaseballUtils.stringToIntegerList(input);
        }

    }

}

