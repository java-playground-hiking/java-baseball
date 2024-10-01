package study.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.exception.enumclass.ErrorCode;

public class InvalidInputException extends RuntimeException{
    private static final Logger logger = LoggerFactory.getLogger(InvalidInputException.class);

    public InvalidInputException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        logger.error("InvalidInputException 발생: {}", errorCode.getMessage());
    }
}
