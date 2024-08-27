package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import domain.Computer;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import util.RandomGenerator;

class ComputerTest {

    @DisplayName("컴퓨터 플레이어의 난수 생성 메서드는 3개여야한다")
    @Test
    void 길이_검증() {
        // Given
        Computer computer = new Computer(new RandomGenerator());

        // When
        int randomNumberGeneratorSize = computer.readyToGameStart().size();

        // Then
        assertThat(randomNumberGeneratorSize).isEqualTo(3);
    }

    @DisplayName("컴퓨터 플레이어의 난수 생성 메서드는 중복을 포함할 수 없다")
    @Test
    void 요소_중복_검사() {
        // Given
        RandomGenerator mockRandom = Mockito.mock(RandomGenerator.class);
        Mockito.when(mockRandom.getRandomNumberToString(9))
                .thenReturn("1", "1", "2", "3");

        Computer computer = new Computer(mockRandom);

        // When
        ArrayList<String> fixture = computer.readyToGameStart();
        System.out.println("fixture = " + fixture);
        int randomNumberGeneratorSize = (int) fixture.stream()
                .distinct()
                .count();

        // Then
        assertThat(randomNumberGeneratorSize).isEqualTo(3);
        assertThat(fixture).containsExactly("1", "2", "3");
    }

}