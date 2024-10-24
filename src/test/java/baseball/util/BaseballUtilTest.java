package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballUtilTest {

    @Test
    @DisplayName("3개의 숫자를 입력 하면 문자열 리스트를 반환한다")
    void test_문자열을_리스트로_변환() {
        assertThat(BaseballUtils.splitByBlank("123")).isEqualTo(List.of("1", "2", "3"));
    }

    @Test
    @DisplayName("리스트 객체의 요소 타입을 문자열에서 숫자형으로 변환한다")
    void test_리스트_요소_타입변경() {
        assertThat(BaseballUtils.convertDataTypesIntoListData(List.of("1", "2", "3"))).isEqualTo(List.of(1, 2, 3));
    }
}
