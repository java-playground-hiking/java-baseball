package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import baseball.domain.count.Count;
import baseball.domain.count.Counts;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ScoreTest {

    private List<Count> setCounts;

    @BeforeEach
    void setUp() {
        setCounts = new ArrayList<>();
        setCounts.add(Count.NOTHING);
        setCounts.add(Count.NOTHING);
        setCounts.add(Count.NOTHING);
    }

    @Test
    @DisplayName("Counts 객체는 매번 새로운 인스턴스가 생성되어야 한다")
    void test_counts_객체_생성_검증() {
        Counts counts1 = Counts.of(Count.NOTHING, Count.NOTHING, Count.NOTHING);
        Counts counts2 = Counts.of(Count.NOTHING, Count.NOTHING, Count.NOTHING);

        assertThat(counts1).isNotSameAs(counts2);
    }

    @Test
    @DisplayName("카운트 리스트 스코어 낫띵")
    void test_스코어_낫띵() {
        Score score = Score.from(
                Counts.of(
                        Count.NOTHING,
                        Count.NOTHING,
                        Count.NOTHING
                )
        );
        assertThat(score.getScreenMessage()).isEqualTo("낫띵");
    }


    @ParameterizedTest
    @DisplayName("카운트 리스트 스코어 스트라이크 카운트 검증")
    @CsvSource(value = {"1,1스트라이크", "2,2스트라이크", "3,3스트라이크"})
    void test_스코어_스트라이크_메세지(int strikeCount, String scoreMessage) {
        for (int i = 0; i < strikeCount; i++) {
            setCounts.set(i, Count.STRIKE);
        }

        Score score = Score.from(
                Counts.of(
                        setCounts.get(0),
                        setCounts.get(1),
                        setCounts.get(2)
                )
        );

        assertThat(score.getScreenMessage()).isEqualTo(scoreMessage);
    }


    @ParameterizedTest
    @DisplayName("카운트 리스트 스코어 볼 카운트 검증")
    @CsvSource(value = {"1,1볼", "2,2볼", "3,3볼"})
    void test_스코어_볼_메세지(int ballCount, String scoreMessage) {

        for (int i = 0; i < ballCount; i++) {
            setCounts.set(i, Count.BALL);
        }

        Score score = Score.from(
                Counts.of(
                        setCounts.get(0),
                        setCounts.get(1),
                        setCounts.get(2)
                )
        );

        assertThat(score.getScreenMessage()).isEqualTo(scoreMessage);
    }

    @Test
    @DisplayName("카운트 리스트 스코어 1볼 1스트라이크")
    void test_스코어_1볼_1스트라이크() {
        Score score = Score.from(
                Counts.of(
                        Count.BALL,
                        Count.STRIKE,
                        Count.NOTHING
                )
        );

        assertThat(score.getScreenMessage()).isEqualTo("1스트라이크 1볼");
    }
}