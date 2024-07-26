package study.calculator;

import calculator.model.StringParser;
import calculator.utils.StringException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class StringParserTest {
    @DisplayName("공백을 기준으로 문자열 분리 테스트")
    @Test
    void validStringParseTest() {
        //given
        final String string = "2 - 32 * 2 / 3";
        final StringParser stringParser = new StringParser(string);

        //when
        String[] parsedString = stringParser.parse();

        //then
        assertThat(parsedString).containsExactly("2", "-", "32", "*", "2", "/", "3");
    }

    @DisplayName("null 또는 blank한 문자열의 예외처리 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrBlankStringExceptionTest(String string) {
        //given
        final StringParser stringParser = new StringParser(string);

        //when
        Throwable throwable = catchThrowable(stringParser::parse);

        //then
        assertThat(throwable)
                .isInstanceOf(StringException.class)
                .hasMessageContaining(StringException.NULL_STRING_EXCEPTION);
    }

}
