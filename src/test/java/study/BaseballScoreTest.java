package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BaseballScoreTest {

    @Test
    @DisplayName("addScore(): 스트라이크인 경우")
    void addScoreStrike(){
        // given
        int index = 1;
        int i = 1;

        // when
        BaseballScore score = new BaseballScore();
        score.addScore(index, i);

        // then
        assertEquals(score.getBallCnt(), 0);
        assertEquals(score.getStrikeCnt(), 1);
        assertEquals(score.getNothingCnt(), 0);
    }

    @Test
    @DisplayName("addScore(): 볼인 경우")
    void addScoreBall(){
        // given
        int index = 2;
        int i = 1;

        // when
        BaseballScore score = new BaseballScore();
        score.addScore(index, i);

        // then
        assertEquals(score.getBallCnt(), 1);
        assertEquals(score.getStrikeCnt(), 0);
        assertEquals(score.getNothingCnt(), 0);
    }

    @Test
    @DisplayName("addScore(): ball, strike 둘 다 아닌 경우")
    void addScoreNothing(){
        // given
        int index = -1;
        int i = 1;

        // when
        BaseballScore score = new BaseballScore();
        score.addScore(index, i);

        // then
        assertEquals(score.getBallCnt(), 0);
        assertEquals(score.getStrikeCnt(), 0);
        assertEquals(score.getNothingCnt(), 1);
    }

    @Test
    @DisplayName("isThreeStrike(): 3 스트라이크인 경우 true 반환")
    void isThreeStrike(){
        // given
        BaseballScore score = new BaseballScore(3, 0, 0);

        // when
        boolean response = score.isThreeStrike();

        // then
        assertTrue(response);
    }

    @Test
    @DisplayName("isThreeStrike(): 3 스트라이크 아닌 경우 false 반환")
    void isNotThreeStrike(){
        // given
        BaseballScore score = new BaseballScore(1, 1, 1);

        // when
        boolean response = score.isThreeStrike();

        // then
        assertFalse(response);
    }

    @Test
    @DisplayName("printScore(): 볼, 스트라이크 점수 출력")
    void scorePrintBallAndStrike(){
        // given
        int ballCnt = 1;
        int strikeCnt = 2;
        int nothingCnt = 0;

        BaseballScore score = new BaseballScore(strikeCnt, ballCnt, nothingCnt);

        // when
        String response = score.printScore();

        // then
        assertEquals(response, ballCnt + "볼 " + strikeCnt + "스트라이크");

    }

    @Test
    @DisplayName("printScore(): 3 스트라이크 점수 출력")
    void scorePrint3Strike(){
        // given
        int ballCnt = 0;
        int strikeCnt = 3;
        int nothingCnt = 0;

        BaseballScore score = new BaseballScore(strikeCnt, ballCnt, nothingCnt);

        // when
        String response = score.printScore();

        // then
        assertEquals(response,  strikeCnt + "스트라이크");

    }

    @Test
    @DisplayName("printScore(): 스트라이크 점수 출력")
    void scorePrintStrike(){
        // given
        int ballCnt = 0;
        int strikeCnt = 2;
        int nothingCnt = 0;

        BaseballScore score = new BaseballScore(strikeCnt, ballCnt, nothingCnt);

        // when
        String response = score.printScore();

        // then
        assertEquals(response,  strikeCnt + "스트라이크");

    }

    @Test
    @DisplayName("printScore(): 볼 점수 출력")
    void scorePrintBall(){
        // given
        int ballCnt = 2;
        int strikeCnt = 0;
        int nothingCnt = 1;

        BaseballScore score = new BaseballScore(strikeCnt, ballCnt, nothingCnt);

        // when
        String response = score.printScore();

        // then
        assertEquals(response, ballCnt + "볼");

    }


    @Test
    @DisplayName("printScore(): 낫싱 점수 출력")
    void scorePrintNothing(){
        // given
        int ballCnt = 0;
        int strikeCnt = 0;
        int nothingCnt = 3;

        BaseballScore score = new BaseballScore(strikeCnt, ballCnt, nothingCnt);

        // when
        String response = score.printScore();

        // then
        assertEquals(response, "낫싱");

    }


}
