package domain;

import static core.SystemConstant.*;
import java.util.ArrayList;
import util.RandomGenerator;

public class Computer {

    public static final int BOUND = 9;
    private final RandomGenerator randomGenerator;
    private final ArrayList<String> randomNumbers = new ArrayList<>();

    public Computer(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public ArrayList<String> readyToGameStart() {

        if (isGenerateRandomNumberSizeEqualToLimit()) {
            return randomNumbers;
        }
        String number = randomGenerator.getRandomNumberToString(BOUND);

        if (doesNotDuplicate(number)) {
            append(number);
        }
        return readyToGameStart();
    }

    private void append(String number) {
        randomNumbers.add(number);
    }

    private boolean isGenerateRandomNumberSizeEqualToLimit() {
        return randomNumbers.size() == INPUT_LIMIT_LENGTH;
    }

    private boolean doesNotDuplicate(String compareInteger) {
        return !randomNumbers.contains(compareInteger);
    }
}
