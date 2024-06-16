package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("주어진 `(1, 2, 3)`의 `size` 메서드를 통해 자료형의 크기 검증")
    void 요구사항1_setSize() {
        // Given
        Set<Integer> fixture = numbers;

        // When
        int getFixtureSize = fixture.size();

        // Then
        assertThat(getFixtureSize).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("주어진 `(1, 2, 3)`에서 `contains`를 통해 개별적 요소가 포함 되는지 검증")
    @ValueSource(ints = {1, 2, 3})
    void 요구사항2_containsEachValues(int input) {
        // Given
        Set<Integer> fixture = numbers;

        // When
        boolean isContains = fixture.contains(input);

        // Then
        assertThat(isContains).isTrue();
    }

    @ParameterizedTest
    @DisplayName("주어진 `(1, 2, 3)`에서 값이 없는 예외 케이스와 정상 케이스 검증")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void 요구사항3_containsException(int value, boolean expected) {
        // Given
        Set<Integer> fixture = numbers;

        // When
        boolean isContains = fixture.contains(value);

        // Then
        assertThat(isContains).isEqualTo(expected);

    }

}