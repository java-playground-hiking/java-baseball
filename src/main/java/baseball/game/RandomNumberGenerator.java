package baseball.game;

import baseball.config.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {

    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        while (numbers.size() < Constants.NUMBER_COUNT) {
            int num = random.nextInt(Constants.MAX_NUMBER) + Constants.MIN_NUMBER;
            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }
        return numbers;
    }
}
