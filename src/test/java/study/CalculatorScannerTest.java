package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.exception.InvalidInputException;
import study.exception.enumclass.ErrorCode;
import study.model.CalculatorScanner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorScannerTest {

    @Test
    @DisplayName("사용자 입력 성공")
    void getInput_success(){
        // given
        String input = "2 + 2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        CalculatorScanner scanner = new CalculatorScanner();

        // when
        String result = scanner.getInput();

        // then
        assertEquals(result, input);
    }


    @Test
    @DisplayName("사용자 입력 시 공백 입력한 경우")
    void getInputEmpty_invalidInputException(){
        // given
        String input = "";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        CalculatorScanner scanner = new CalculatorScanner();

        // when
        InvalidInputException fail = assertThrows(InvalidInputException.class,
                () -> scanner.getInput());

        // then
        assertEquals(fail.getMessage(), ErrorCode.EMPTY_INPUT.getMessage());
    }

}
