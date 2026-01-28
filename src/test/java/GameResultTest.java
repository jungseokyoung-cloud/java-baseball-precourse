package domains;

import static org.assertj.core.api.Assertions.*;

import Domains.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameResultTest {
    @DisplayName("3 스트라이크일 때 승리 여부를 정확히 판정하는지 확인한다.")
    @Test
    void isThreeStrike_True_WhenStrikesIsThree() {
        GameResult result = new GameResult(3, 0);
        assertThat(result.isThreeStrike()).isTrue();
    }

    @DisplayName("스트라이크와 볼이 모두 0이면 '낫싱'으로 판정한다.")
    @Test
    void isNothing_True_WhenNoStrikeAndNoBall() {
        GameResult result = new GameResult(0, 0);
        assertThat(result.isNothing()).isTrue();
    }

    @DisplayName("하나라도 맞으면 '낫싱'이 아니다.")
    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "0, 1",
            "1, 1"
    })
    void isNothing_False_WhenAnyMatch(int strikes, int balls) {
        GameResult result = new GameResult(strikes, balls);
        assertThat(result.isNothing()).isFalse();
    }
}