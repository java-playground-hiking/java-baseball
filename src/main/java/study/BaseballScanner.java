package study;

import study.messages.ErrorMessages;

import java.util.*;

public class BaseballScanner {
    private final Scanner scanner;

    public BaseballScanner(){
        this.scanner = new Scanner(System.in);
    }

    public List<Integer> askNumbers() {
        System.out.println("숫자를 입력해 주세요 : ");
        String input;

        try{
            input = checkLength(scanner.next());
        } catch (NoSuchElementException ex){
            throw new NoSuchElementException(ErrorMessages.INVALID_INPUT);
        }

        return convertList(input);
    }

    public int askReplay(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input;

        try{
            input = validateOneOrTwo(scanner.nextInt());
        } catch (NoSuchElementException ex){
            throw new NoSuchElementException(ErrorMessages.INVALID_INPUT_REPLAY);
        }

        return input;

    }

    public String checkLength(String input){
        input = input.replace(" ", "");

        if (input.length() != 3){
            throw new NoSuchElementException(ErrorMessages.INVALID_INPUT);
        }
        return input;
    }

    public int parseStringToInt(String str){
        int result;

        try{
            result = Integer.parseInt(str);
        } catch (NumberFormatException ex){
            throw new NumberFormatException(ErrorMessages.INVALID_INPUT_NUMBER);
        }

        return result;
    }


    public List<Integer> convertList(String input){
        List<Integer> numbers = new ArrayList<>();
        String[] inputArr = input.split("");

        for (String str: inputArr){
            int number = parseStringToInt(str);
            numbers.add(number);
        }

        return numbers;
    }


    public int validateOneOrTwo(int input){
        if (input == 1 || input == 2){
            return input;
        }

        throw new NoSuchElementException(ErrorMessages.INVALID_INPUT_REPLAY);
    }


    public void close(){
        scanner.close();
    }
}
