package study.exception.enumclass;

public enum ErrorCode {

    NON_NUMERIC_INPUT(1, "숫자가 아닌 값을 입력했습니다."),
    DIVISION_ZERO(2, "0으로 나눌 수 없습니다."),
    INVALID_FORMAT(3, "잘못된 형식입니다. 정확한 수식을 입력해주세요."),
    EMPTY_INPUT(4, "공백은 입력할 수 없습니다.");



    private final int id;
    private final String message;

    ErrorCode(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
