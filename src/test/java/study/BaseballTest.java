package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class BaseballTest {

    @Test
    @DisplayName("play(): 3 스트라이크")
    void play3Strike(){
        // given
        List<Integer> inputList = Arrays.asList(3, 5, 6);
        List<Integer> answerList = Arrays.asList(3, 5, 6);

        // when
        Baseball baseball = new Baseball(answerList);
        BaseballScore response = baseball.play(inputList);

        // then
        assertEquals(response.getStrikeCnt(), 3);
        assertEquals(response.getBallCnt(), 0);
        assertEquals(response.getNothingCnt(), 0);
    }

    @Test
    @DisplayName("play(): 1 스트라이크 2볼")
    void play1Strike2Ball(){
        // given
        List<Integer> inputList = Arrays.asList(3, 5, 6);
        List<Integer> answerList = Arrays.asList(3, 6, 5);

        // when
        Baseball baseball = new Baseball(answerList);
        BaseballScore response = baseball.play(inputList);

        // then
        assertEquals(response.getStrikeCnt(), 1);
        assertEquals(response.getBallCnt(), 2);
        assertEquals(response.getNothingCnt(), 0);
    }

    @Test
    @DisplayName("play(): 3볼")
    void play3Ball(){
        // given
        List<Integer> inputList = Arrays.asList(3, 5, 6);
        List<Integer> answerList = Arrays.asList(5, 6, 3);


        // when
        Baseball baseball = new Baseball(answerList);
        BaseballScore response = baseball.play(inputList);

        // then
        assertEquals(response.getStrikeCnt(), 0);
        assertEquals(response.getBallCnt(), 3);
        assertEquals(response.getNothingCnt(), 0);

    }

    @Test
    @DisplayName("play(): 낫싱")
    void playNothing(){
        // given
        List<Integer> inputList = Arrays.asList(3, 5, 6);
        List<Integer> answerList = Arrays.asList(7, 8, 9);


        // when
        Baseball baseball = new Baseball(answerList);
        BaseballScore response = baseball.play(inputList);


        // then
        assertEquals(response.getStrikeCnt(), 0);
        assertEquals(response.getBallCnt(), 0);
        assertEquals(response.getNothingCnt(), 3);

    }


    @RepeatedTest(10) // 10번 반복 테스트
    @DisplayName("getAnswer() 성공: 랜덤 3자리 수 생성")
    void getAnswer(){
        // given
        // when
        Baseball baseball = new Baseball();
        List<Integer> response = baseball.getAnswer();

        // then
        assertEquals(response.size(), 3);
        assertNotNull(response.get(0));
        assertNotNull(response.get(1));
        assertNotNull(response.get(2));
        assertNotEquals(response.get(0), response.get(1));
        assertNotEquals(response.get(0), response.get(2));
        assertNotEquals(response.get(1), response.get(2));
    }

    @Test
    @DisplayName("addUniqueNumber(): 리스트에 중복된 숫자 존재하지 않을 경우 리스트에 추가")
    void addUniqueNumber(){
        // given
        int num = 3;
        List<Integer> answers = new ArrayList<>();
        answers.add(4);
        answers.add(1);

        // when
        Baseball baseball = new Baseball();
        List<Integer> response = baseball.addUniqueNumber(num, answers);

        // then
        assertEquals(response.size(), 3);
        assertEquals(response.get(0), answers.get(0));
        assertEquals(response.get(1), answers.get(1));
        assertEquals(response.get(2), num);
    }

    @Test
    @DisplayName("addUniqueNumber(): 리스트에 중복 숫자 존재하는 경우 리스트에 추가 안됨")
    void addDuplicatedNumber(){
        // given
        int num = 1;
        List<Integer> answers = new ArrayList<>();
        answers.add(4);
        answers.add(1);

        // when
        Baseball baseball = new Baseball();
        List<Integer> response = baseball.addUniqueNumber(num, answers);

        // then
        assertEquals(response.size(), answers.size());
        assertEquals(response.get(0), answers.get(0));
        assertEquals(response.get(1), answers.get(1));
    }

}
