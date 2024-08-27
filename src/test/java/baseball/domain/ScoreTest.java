package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import core.AppException;
import domain.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class ScoreTest {

    @DisplayName("스코어의 볼을 증가 시키면 변경 된 볼 카운트를 반환한다")
    @Test
    void 볼_증가() {
        // Given
        Score score = new Score();

        // When
        score.ballIncrement();

        // Then
        assertThat(score.getScoreRecordResult()).isEqualTo("1볼");
    }

    @DisplayName("스코어의 스트라이크를 증가 시키면 변경 된 스트라이크 카운트를 반환한다")
    @Test
    void 스트라이크_증가() {
        // Given
        Score score = new Score();

        // When
        score.strikeIncrement();

        // Then
        assertThat(score.getScoreRecordResult()).isEqualTo("1스트라이크");
    }

    @DisplayName("볼 카운트는 최대 3까지 증가 할 수 있다")
    @Test
    void 볼_카운트_최대값() {
        // Given
        Score score = new Score();

        // When
        score.ballIncrement();
        score.ballIncrement();
        score.ballIncrement();
        assertThatThrownBy(() -> {
            score.ballIncrement();
        })
            // Then
            .isInstanceOf(AppException.class)
            .hasMessageContaining("볼 카운트는 최대 3까지 증가할 수 있습니다");
    }

    @DisplayName("스트라이크 카운트는 최대 3까지 증가 할 수 있다")
    @Test
    void 스트라이크_카운트_최대값() {
        // Given
        Score score = new Score();

        // When
        score.strikeIncrement();
        score.strikeIncrement();
        score.strikeIncrement();
        assertThatThrownBy(() -> {
            score.strikeIncrement();
        })
            // Then
            .isInstanceOf(AppException.class)
            .hasMessageContaining("스트라이크 카운트는 최대 3까지 증가할 수 있습니다");
    }


    @DisplayName("스코어의 스트라이크와 볼을 동시에 증가 시키면 볼과 스트라이크의 결과를 반환한다")
    @Test
    void 볼_스트라이크_반환() {
        // Given
        Score score = new Score();

        // When
        score.strikeIncrement();
        score.ballIncrement();

        // Then
        assertThat(score.getScoreRecordResult()).isEqualTo("1볼 1스트라이크");
    }

    @DisplayName("스코어에서 스트라이크 카운트가 3이라면 아웃 상태 값을 반환한다")
    @Test
    void 스트라이크3_아웃_반환() {
        // Given
        Score score = new Score();

        // When
        score.strikeIncrement();
        score.strikeIncrement();
        score.strikeIncrement();

        System.out.println("score.getScoreRecordResult() = " + score.getScoreRecordResult());

        // Then
        assertThat(score.isStrikeCountEqualToWinningStrikeCount()).isTrue();
    }

    @DisplayName("스코어에서 스트라이크 카운트가 3 미만이라면 아웃 상태가 아닌 값을 반환한다")
    @Test
    void 스트라이크3_아웃_아님_반환() {
        // Given
        Score score = new Score();

        // When
        score.strikeIncrement();
        score.strikeIncrement();

        // Then
        assertThat(score.isStrikeCountEqualToWinningStrikeCount()).isFalse();
    }

    @DisplayName("스코어는 볼과 스트라이크 카운트가 증가하지 않으면 낫싱을 반환한다")
    @Test
    void 스코어_낫싱_반환() {
        // Given
        Score score = new Score();

        // When
        // Pass

        // Then
        assertThat(score.getScoreRecordResult()).isEqualTo("낫싱");

    }
}
