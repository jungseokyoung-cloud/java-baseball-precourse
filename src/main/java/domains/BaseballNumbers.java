package domains;

import java.util.List;
import java.util.Collections;

public class BaseballNumbers {
    private final List<Integer> numbers;

    public BaseballNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public GameResult compare(List<Integer> otherNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < numbers.size(); i++) {
            if (isStrike(i, otherNumbers)) {
                strikes++;
            } else if (isBall(i, otherNumbers)) {
                balls++;
            }
        }
        return new GameResult(strikes, balls);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private boolean isStrike(int index, List<Integer> otherNumbers) {
        return numbers.get(index).equals(otherNumbers.get(index));
    }

    private boolean isBall(int index, List<Integer> otherNumbers) {
        return !isStrike(index, otherNumbers) && numbers.contains(otherNumbers.get(index));
    }
}