package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import domain.Judgment;
import domain.Score;
import domain.User;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JudgmentTest {

    private static ArrayList<String> randomNumbers;

    @BeforeAll
    static void setUp() {
        randomNumbers = new ArrayList<>(Arrays.asList("1", "2", "3"));
    }

    @DisplayName("같은 위치에 숫자는 다르지만 다른 위치에 속해 있는 경우 볼로 판정한다.")
    @ParameterizedTest
    @CsvSource({"345,1볼", "314,2볼", "312,3볼"})
    void 심판_볼_판정(String numberToString, String result) {
        Judgment judgmentFixture = new Judgment(randomNumbers);
        User userFixture = new User(numberToString);

        // Given
        ArrayList<String> userInputNumbers = userFixture.getUserInputNumbers();

        // When
        Score score = judgmentFixture.judge(userInputNumbers);

        // Then
        assertThat(score.getScoreRecordResult()).isEqualTo(result);
    }

    @DisplayName("같은 위치에 같은 숫자가 있는 경우 스트라이크로 판정한다.")
    @ParameterizedTest
    @CsvSource({"145,1스트라이크", "125,2스트라이크", "123,3스트라이크"})
    void 심판_스트라이크_판정(String numberToString, String result) {
        Judgment judgmentFixture = new Judgment(randomNumbers);
        User userFixture = new User(numberToString);

        // Given
        ArrayList<String> userInputNumbers = userFixture.getUserInputNumbers();

        // When
        Score score = judgmentFixture.judge(userInputNumbers);

        // Then
        assertThat(score.getScoreRecordResult()).isEqualTo(result);
    }

    @DisplayName("같은 위치에 같은 숫자가 있는 경우 스트라이크로 판정한다.")
    @Test
    void 심판_낫싱_판정() {
        Judgment judgmentFixture = new Judgment(randomNumbers);
        User userFixture = new User("789");

        // Given
        ArrayList<String> userInputNumbers = userFixture.getUserInputNumbers();

        // When
        Score score = judgmentFixture.judge(userInputNumbers);

        // Then
        assertThat(score.getScoreRecordResult()).isEqualTo("낫싱");
    }

}