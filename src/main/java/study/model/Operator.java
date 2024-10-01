package study.model;

import study.exception.DivisionZeroException;
import study.exception.InvalidFormatException;
import study.exception.enumclass.ErrorCode;

public class Operator {
    public int execute(String operators, int nowValue, int nextValue){
        switch (operators){
            case "+":
                return add(nowValue, nextValue);
            case "-":
                return minus(nowValue, nextValue);
            case "*":
                return multiply(nowValue, nextValue);
            case "/":
                return divide(nowValue, nextValue);
        }
        throw new InvalidFormatException(ErrorCode.INVALID_FORMAT);
    }

    public int add(int num1, int num2){
        return num1 + num2;
    }

    public int minus(int num1, int num2){
        return num1 - num2;
    }

    public int multiply(int num1, int num2){
        return num1 * num2;
    }

    public int divide(int num1, int num2){
        if (num2 == 0){
            throw new DivisionZeroException(ErrorCode.DIVISION_ZERO);
        }

        return num1 / num2;
    }
}
