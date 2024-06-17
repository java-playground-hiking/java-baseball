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
            if (y == 0) {
                throw new ArithmeticException("can't division by zero");
            }
            return x / y;
        });
    }

    /**
     *  계산기 서비스에서 지정한 연산자 여부 확인
     * @param string 문자열 데이터
     * @return boolean - true: 연산자, false: 일반 문자, 그 외 `IllegalArgumentException` 익셉션 발생
     */
    public static boolean isOperator(String string) {
        List<String> keys = new ArrayList<>(operator.keySet());

        if (keys.contains(string)) {
            return true;
        }
        throw new IllegalArgumentException("Input the invalid operator");
    }

    public static BiFunction<Integer, Integer, Integer> getOperator(String symbol) {
        BiFunction<Integer, Integer, Integer> op = operator.get(symbol);

        if (op == null) {
            throw new IllegalArgumentException("does not matching operator symbol");
        };
        return op;
    }


}
