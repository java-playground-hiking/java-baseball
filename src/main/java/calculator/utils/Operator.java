package calculator.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Operator {

    // NOTE: 연산자 옵션
    private static final Map<String, BiFunction<Integer, Integer, Integer>> operator = new HashMap<>();
    static {
        operator.put("+", (x, y) -> x + y);
        operator.put("-", (x, y) -> x - y);
        operator.put("*", (x, y) -> x * y);
        operator.put("/", (x, y) -> {
            if (x == 0 || y == 0) {
                throw new ArithmeticException("can't division by zero");
            }
            return x / y;
        });
    }


    public static BiFunction<Integer, Integer, Integer> getOperator(String symbol) {
        BiFunction<Integer, Integer, Integer> op = operator.get(symbol);

        if (op == null) {
            throw new IllegalArgumentException("does not matching operator symbol");
        };
        return op;
    }


}
