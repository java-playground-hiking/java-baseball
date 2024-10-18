package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.messages.ErrorMessages;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BaseballScannerTest {

    // <scanner 테스트 하기 위해 System.setIn() 사용 시 주의할 점>
    // System.in 에 대한 입력 스트림이 설정 되기 전에 scanner 가 초기화 되면 scanner 가 읽을 데이터가 없는 상태가 될 수 있음
    // 특히 @BeforeEach 사용 시 System.in 설정 전에 먼저 객체가 생성되서 입력값이 없어서 예외 발생함

    @Test
    @DisplayName("askNumbers(): 사용자 입력 성공")
    void askNumbers(){
        // given
        String input = "456";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        BaseballScanner scanner = new BaseballScanner();
        List<Integer> response = scanner.askNumbers();

        // then
        assertEquals(response.get(0), 4);
        assertEquals(response.get(1), 5);
        assertEquals(response.get(2), 6);
    }

    @Test
    @DisplayName("askNumbers(): 공백이 포함된 숫자 입력으로 예외 발생")
    void askNumbersContainEmpty_exception(){
        // given
        String input = "4 6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        BaseballScanner scanner = new BaseballScanner();
        NoSuchElementException fail = assertThrows(NoSuchElementException.class, scanner::askNumbers);

        // then
        assertEquals(fail.getMessage(), ErrorMessages.INVALID_INPUT);
    }

    @Test
    @DisplayName("askNumbers(): 숫자 3자리 이상을 입력으로 예외 발생")
    void askNumbersInputOverSizeThree_exception(){
        // given
        String input = "123456";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        BaseballScanner scanner = new BaseballScanner();
        NoSuchElementException fail = assertThrows(NoSuchElementException.class, scanner::askNumbers);

        // then
        assertEquals(fail.getMessage(), ErrorMessages.INVALID_INPUT);
    }

    @Test
    @DisplayName("askNumbers(): 문자열 입력으로 예외 발생")
    void askNumbersInputString_exception(){
        // given
        String input = "문자열";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        BaseballScanner scanner = new BaseballScanner();
        NumberFormatException fail = assertThrows(NumberFormatException.class, scanner::askNumbers);

        // then
        assertEquals(fail.getMessage(), ErrorMessages.INVALID_INPUT_NUMBER);
    }

    @Test
    @DisplayName("askNumbers(): 공백 입력으로 예외 발생")
    void askNumbersInputEmpty_exception(){
        // given
        String input = " ";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        BaseballScanner scanner = new BaseballScanner();
        NoSuchElementException fail = assertThrows(NoSuchElementException.class, scanner::askNumbers);

        // then
        assertEquals(fail.getMessage(), ErrorMessages.INVALID_INPUT);
    }


    @Test
    @DisplayName("askReplay(): 재게임 입력 성공")
    void askReplay(){
        // given
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        BaseballScanner scanner = new BaseballScanner();
        int response = scanner.askReplay();

        // then
        assertEquals(response, Integer.parseInt(input));
    }

    @Test
    @DisplayName("askReplay(): 문자열 입력으로 예외 발생")
    void askReplayInputString_exception(){
        // given
        String input = "문자열";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        BaseballScanner scanner = new BaseballScanner();
        NoSuchElementException fail = assertThrows(NoSuchElementException.class, scanner::askReplay);

        // then
        assertEquals(fail.getMessage(), ErrorMessages.INVALID_INPUT_REPLAY);
    }


    @Test
    @DisplayName("askReplay(): 공백 입력으로 예외 발생")
    void askReplayInputEmpty_exception(){
        // given
        String input = " ";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        BaseballScanner scanner = new BaseballScanner();
        NoSuchElementException fail = assertThrows(NoSuchElementException.class, scanner::askReplay);

        // then
        assertEquals(fail.getMessage(), ErrorMessages.INVALID_INPUT_REPLAY);
    }

    @Test
    @DisplayName("askReplay(): 숫자 1 또는 2 이외의 숫자 입력으로 예외 발생")
    void askReplayInputTwoNumber_exception(){
        String input = "34";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        BaseballScanner scanner = new BaseballScanner();
        NoSuchElementException fail = assertThrows(NoSuchElementException.class, scanner::askReplay);

        // then
        assertEquals(fail.getMessage(), ErrorMessages.INVALID_INPUT_REPLAY);
    }

    
    @Test
    @DisplayName("checkLength(): 숫자 3자리 검증 성공")
    void checkLength(){
        // given
        String input = "123";

        // when
        BaseballScanner scanner = new BaseballScanner();
        String response = scanner.checkLength(input);

        // then
        assertEquals(response, input);
    }

    @Test
    @DisplayName("checkLength(): 숫자 3자리 이상을 입력으로 예외 발생")
    void checkLengthInputOverSizeThree_exception(){
        // given
        String input = "123456";

        // when
        BaseballScanner scanner = new BaseballScanner();
        NoSuchElementException fail = assertThrows(NoSuchElementException.class, () -> scanner.checkLength(input));

        // then
        assertEquals(fail.getMessage(), ErrorMessages.INVALID_INPUT);
    }

    @Test
    @DisplayName("parseStringToInt(): 문자열 숫자로 변환 성공")
    void parseStringToInt(){
        // given
        String input = "123";

        // when
        BaseballScanner scanner = new BaseballScanner();
        int response = scanner.parseStringToInt(input);

        // then
        assertEquals(response, 123);
    }

    @Test
    @DisplayName("parseStringToInt(): 문자열 숫자 변환 실패로 예외 발생")
    void parseInputString_exception(){
        // given
        String input = "문자열";

        // when
        BaseballScanner scanner = new BaseballScanner();
        NumberFormatException fail = assertThrows(NumberFormatException.class, () -> scanner.parseStringToInt(input));

        // then
        assertEquals(fail.getMessage(), ErrorMessages.INVALID_INPUT_NUMBER);
    }

    @Test
    @DisplayName("convertList(): 문자열을 숫자 리스트로 변환 성공")
    void convertList(){
        // given
        String input = "123";

        // when
        BaseballScanner scanner = new BaseballScanner();
        List<Integer> response = scanner.convertList(input);

        // then
        assertEquals(response.get(0), 1);
        assertEquals(response.get(1), 2);
        assertEquals(response.get(2), 3);
    }



    @Test
    @DisplayName("convertList(): 문자열 숫자 리스트 변환 실패로 예외 발생")
    void convertListInputString_exception(){
        // given
        String input = "문자열";

        // when
        BaseballScanner scanner = new BaseballScanner();
        NumberFormatException fail = assertThrows(NumberFormatException.class, () -> scanner.convertList(input));

        // then
        assertEquals(fail.getMessage(), ErrorMessages.INVALID_INPUT_NUMBER);
    }

    @Test
    @DisplayName("validateOneOrTwo(): 숫자 1 입력으로 성공")
    void validateOneOrTwoInput1(){
        // given
        int input = 1;

        // when
        BaseballScanner scanner = new BaseballScanner();
        int response = scanner.validateOneOrTwo(input);

        // then
        assertEquals(response, input);
    }

    @Test
    @DisplayName("validateOneOrTwo(): 숫자 2 입력으로 성공")
    void validateOneOrTwoInput2(){
        // given
        int input = 2;

        // when
        BaseballScanner scanner = new BaseballScanner();
        int response = scanner.validateOneOrTwo(input);

        // then
        assertEquals(response, input);
    }


    @Test
    @DisplayName("validateOneOrTwo(): 1이나 2가 아닌 숫자 입력으로 예외 발생")
    void validateOneOrTwoInputEither1Or2_exception(){
        // given
        int input = 222;

        // when
        BaseballScanner scanner = new BaseballScanner();
        NoSuchElementException fail = assertThrows(NoSuchElementException.class, () -> scanner.validateOneOrTwo(input));

        // then
        assertEquals(fail.getMessage(), ErrorMessages.INVALID_INPUT_REPLAY);
    }


}
