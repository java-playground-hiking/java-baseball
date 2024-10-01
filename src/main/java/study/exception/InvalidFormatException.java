package study.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.exception.enumclass.ErrorCode;


public class InvalidFormatException extends RuntimeException{
    private static final Logger logger = LoggerFactory.getLogger(InvalidFormatException.class);

    public InvalidFormatException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        logger.error("InvalidFormatException 발생: {}", errorCode.getMessage());
    }
}
