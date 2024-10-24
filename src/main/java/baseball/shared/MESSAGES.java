package baseball.shared;

public enum MESSAGES {
    USER_INSTANCE_ERROR_MESSAGE("3개의 숫자를 입력하세요"),
    BALL_INSTANCE_ERROR("올바르지 않은 입력입니다."),
    BALL_LIST_INSTANCE_ERROR("BallNumber는 3개가 최대 입니다.");

    private String message;

    MESSAGES(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
