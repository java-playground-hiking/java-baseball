package study.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.exception.enumclass.ErrorCode;

public class DivisionZeroException extends RuntimeException{
    private static final Logger logger = LoggerFactory.getLogger(DivisionZeroException.class);

    public DivisionZeroException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        logger.error("DivisionZeroException 발생: {}", errorCode.getMessage());
    }
}
