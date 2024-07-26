package calculator.utils;

public class StringException extends RuntimeException {
    public static final String NULL_STRING_EXCEPTION = "문자열이 null 또는 비어있습니다.";
    public static final String INVALID_STRING_TOKEN_COUNT = "계산식의 토큰 개수가 올바르지 않습니다.";
    public static final String INVALID_OPERATOR = "연산자가 올바르지 않습니다.";
    public static final String INVALID_LOCATION = "문자의 위치가 올바르지 않습니다.";
    public static final String INVALID_DIVIDE_VALUE = "나누는 수는 0이 될 수 없습니다.";

    public StringException() {
        super();
    }

    public StringException(String message) {
        super(message);
    }
}
