package study;

import jdk.internal.joptsimple.internal.Strings;
import org.assertj.core.internal.Integers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @DisplayName("HashSet의 크기 확인")
    void testHashSetSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("1,2,3 존재하는지 확인")
    void testContainValue(int number) {
        assertTrue(numbers.contains(number));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, true",
            "2, true",
            "3, true",
            "4, false",
            "5, false"}, delimiter = ',')
    @DisplayName("존재하는 값은 true, 아닌 값은 false 반환하는지 확인")
    void testIsContainValue(int number, boolean expectedResult) {
        assertThat(numbers.contains(number)).isEqualTo(expectedResult);
    }
}
