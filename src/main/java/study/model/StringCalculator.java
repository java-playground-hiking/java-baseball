package study.model;

import study.exception.InvalidFormatException;
import study.exception.InvalidInputException;
import study.exception.enumclass.ErrorCode;


public class StringCalculator {
    public int calculate(String value){
        String[] values = value.split(" ");

        int total = parseInteger(values[0]);

        for (int i=1; i<values.length; i+=2){
            String operators = values[i];
            int nextValue = getNextValue(values, i+1);

            Operator operator = new Operator();
            total = operator.execute(operators, total, nextValue);
        }

        return total;

    }

    public int getNextValue(String[] values, int index){
        if (index >= values.length){
            throw new InvalidFormatException(ErrorCode.INVALID_FORMAT);
        }
        return parseInteger(values[index]);
    }

    public int parseInteger(String value){
        try{
            return Integer.parseInt(value);
        } catch (NumberFormatException e){
            throw new InvalidInputException(ErrorCode.NON_NUMERIC_INPUT);
        }
    }



}
