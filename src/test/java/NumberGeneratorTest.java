package domains;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    @DisplayName("생성된 숫자는 정확히 3개여야 한다.")
    @Test
    void generateNumberCountTest() {
        BaseballNumbers numbers = NumberGenerator.generate();
        assertThat(numbers.getNumbers()).hasSize(3);
    }

    @DisplayName("생성된 숫자는 1에서 9 사이의 범위여야 한다.")
    @RepeatedTest(100) // 난수 생성이므로 여러 번 반복해서 검증
    void generateNumberRangeTest() {
        BaseballNumbers numbers = NumberGenerator.generate();

        for (int number : numbers.getNumbers()) {
            assertThat(number).isBetween(1, 9);
        }
    }

    @DisplayName("생성된 숫자들 사이에는 중복이 없어야 한다.")
    @Test
    void generateUniqueNumberTest() {
        BaseballNumbers numbers = NumberGenerator.generate();
        List<Integer> numberList = numbers.getNumbers();

        // Set에 넣었을 때도 크기가 3이라면 중복이 없는 것
        assertThat(Set.copyOf(numberList)).hasSize(3);
    }
}