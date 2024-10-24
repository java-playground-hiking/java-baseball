package study;

import study.message.ErrorMessages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseballUtils {

    private static final int LIST_SIZE = 3;
    private static final int MAX_NUMBER = 9;
    private static final Random random = new Random();


    public static void addUniqueNumber(List<Integer> answer) {
        int num = getRandomNumber();

        if (!answer.contains(num)){
            answer.add(num);
        }
    }

    public static int getRandomNumber() {
        return random.nextInt(MAX_NUMBER)+1;
    }

    public static List<Integer> stringToIntegerList(String input) {
        List<Integer> list = new ArrayList<>();
        String[] strArr = input.split("");

        for (String s : strArr) {
            list.add(stringParseInt(s));
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

    public static boolean checkLength(String input) {
        return input.length() == LIST_SIZE;
    }
}
