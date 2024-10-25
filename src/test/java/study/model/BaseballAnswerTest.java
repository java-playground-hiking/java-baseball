package study.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BaseballAnswerTest {

    @Test
    @DisplayName("정답 생성")
    void createAnswer(){
        // given
        BaseballAnswer baseballAnswer = new BaseballAnswer();

        // when
        baseballAnswer.createAnswer();

        // then
        List<Integer> response = baseballAnswer.getAnswer();
        assertEquals(response.size(), 3);
        assertNotEquals(response.get(0), response.get(1));
        assertNotEquals(response.get(0), response.get(2));
        assertNotEquals(response.get(1), response.get(2));
    }

}
