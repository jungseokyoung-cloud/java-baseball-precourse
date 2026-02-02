package domains;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class NumberGenerator {
    private static final int NUMBER_COUNT = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static BaseballNumbers generate() {
        Set<Integer> uniqueNumbers = new LinkedHashSet<>();
        Random random = new Random();

        while (uniqueNumbers.size() < NUMBER_COUNT) {
            int randomNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            uniqueNumbers.add(randomNumber);
        }

        return new BaseballNumbers(new ArrayList<>(uniqueNumbers));
    }
}