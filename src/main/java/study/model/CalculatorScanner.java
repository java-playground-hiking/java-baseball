package study.model;

import study.exception.InvalidInputException;
import study.exception.enumclass.ErrorCode;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class CalculatorScanner {
    private final Scanner scanner;

    public CalculatorScanner(){
        this.scanner = new Scanner(System.in);
    }

    public String getInput(){
        System.out.println("수식을 입력해주세요: ");
        String input;

        try {
            input = scanner.nextLine();
        } catch (NoSuchElementException ex){
            throw new InvalidInputException(ErrorCode.EMPTY_INPUT);
        }

        return input;
    }
}
