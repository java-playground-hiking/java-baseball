package study.utils;

import study.message.ErrorMessages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseballUtils {

    private static final int MAX_LIST_SIZE = 3;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final Random random = new Random();


    public static int getRandomNumber() {
        return random.nextInt(MAX_RANDOM_NUMBER)+1;
    }

    public static String removeSpaces(String input){
        return input.replaceAll(" ", "");
    }

    public static void checkLength(String input) {
        if (input.length() != MAX_LIST_SIZE){
            throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT_LENGTH);
        }
    }

    public static String[] stringToArrays(String input){
        return input.split("");
    }

    public static List<Integer> stringToIntegerList(String input) {
        List<Integer> list = new ArrayList<>();
        String[] strArr = stringToArrays(input);

        for (String s : strArr) {
            list.add(BaseballUtils.stringParseInt(s));
        }

        return list;
    }

    public static int stringParseInt(String str){
        int value = 0;

        try {
            value = Integer.parseInt(str);
        } catch (NumberFormatException e){
            throw new NumberFormatException(ErrorMessages.INVALID_INPUT_NUMBER);

        }

        return value;
    }

}
