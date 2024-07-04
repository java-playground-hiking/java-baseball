package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @DisplayName("size() 메서드를 활용한 Set 크기 확인")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("contains() 메서드를 활용해 값 확인")
    @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("contains() 메서드를 활용해 값 확인,ParameterizedTest 활용")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains_ParameterizedTest_annotation(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("contains() 메서드를 활용해 값 확인,@CsvSource 활용")
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void contains_CsvSource_annotation(int input, boolean expected) {

        assertEquals(expected, numbers.contains(input));
    }
}
