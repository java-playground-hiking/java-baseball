package baseball.game;

import baseball.config.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class RandomNumberGeneratorTest {

    private RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    public void setUp() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @Test
    @DisplayName("생성된 숫자 개수 맞는지 확인해보셈")
    public void testGenerateNumberCount() {
        List<Integer> numbers = randomNumberGenerator.generate();
        assertEquals(Constants.NUMBER_COUNT, numbers.size(), "생성된 숫자의 개수가 올바르지 않음");
    }

    @Test
    @DisplayName("숫자 중복 안되는지 확인해보셈")
    public void testNoDuplicateNumbers() {
        List<Integer> numbers = randomNumberGenerator.generate();
        Set<Integer> numberSet = new HashSet<>(numbers);
        assertEquals(numbers.size(), numberSet.size(), "중복된 숫자가 있음");
    }

    @Test
    @DisplayName("숫자 범위 맞는지 확인해보셈")
    public void testNumberRange() {
        List<Integer> numbers = randomNumberGenerator.generate();
        for (int num : numbers) {
            assertTrue(num >= Constants.MIN_NUMBER && num <= Constants.MAX_NUMBER,
                    "숫자가 범위를 벗어남: " + num);
        }
    }
}
