package study.mission0;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }


    @Test
    @DisplayName("요구사항 1: Set 의 크기를 확인한다.")
    void checkSize(){
        assertThat(numbers.size()).isEqualTo(4);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항 2: contains() 메소드를 활용해 값 존재하는지 확인하며 ParameterizedTest 를 이용해 중복코드를 제거한다.")
    void isContainsNumber(int number){
        assertThat(numbers.contains(number)).isTrue();
    }


    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    @DisplayName("요구사항 3: contains() 메소드를 활용해 값 존재하는지 확인하며 입력값에 따라 true, false 를 반환한다.")
    void isContains_expectedTrueOrFalse(int input, boolean expected){
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}
