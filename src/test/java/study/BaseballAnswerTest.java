package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BaseballAnswerTest {

    @Test
    @DisplayName("정답 생성")
    void getAnswer(){
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

    @Test
    @DisplayName("리스트 내 중복 체크 후 중복값 없어 리스트에 추가")
    void addUniqueNumber() {
        // given
        List<Integer> answer = new ArrayList<>();
        answer.add(1);
        answer.add(2);

        BaseballAnswer baseballAnswer = new BaseballAnswer();

        // when
        baseballAnswer.addUniqueNumber(answer);

        // then
        assertEquals(answer.size(), 3);
        assertEquals(answer.get(0), 1);
        assertEquals(answer.get(1), 2);
        assertNotNull(answer.get(2));

    }
}
