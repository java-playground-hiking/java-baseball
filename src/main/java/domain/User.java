package domain;


import static core.SystemConstant.*;

import java.util.ArrayList;
import java.util.Arrays;
import core.AppException;

public class User {

    private final static int NUMBER_LIMIT_LENGTH = INPUT_LIMIT_LENGTH;
    private final ArrayList<String> userInputNumbers;

    public User(String userInputNumber) {
        if (invalidLengthUserInputNumber(userInputNumber)) {
            throw new AppException("입력한 숫자의 길이가 올바르지 않습니다.");
        }

        if (doesNotNumeric(userInputNumber)) {
            throw new AppException("지정 되지 않은 타입의 입력입니다.");
        }

        this.userInputNumbers = convertStringToArrayList(userInputNumber);

        if (hasZeroNumber()) {
            throw new AppException("0은 입력 할 수 없습니다.");
        }

    }

    public ArrayList<String> getUserInputNumbers() {
        return userInputNumbers;
    }

    private static ArrayList<String> convertStringToArrayList(String userInput) {
        return new ArrayList<>(Arrays.asList(userInput.split("")));
    }

    private boolean hasZeroNumber() {
        return this.userInputNumbers.contains("0");
    }

    private boolean doesNotNumeric(String userInput) {
        try {
            Integer.valueOf(userInput);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    private boolean invalidLengthUserInputNumber(String userInput) {
        return !(userInput.length() == NUMBER_LIMIT_LENGTH);
    }
}
