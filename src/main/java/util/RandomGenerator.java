package util;

import java.util.Random;

public class RandomGenerator {

    private final Random randomGenerator = new Random();

    public String getRandomNumberToString(int bound) {
        return String.valueOf(randomGenerator.nextInt(bound) + 1);
    }
}
