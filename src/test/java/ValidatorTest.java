package domains;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @DisplayName("재시작 명령어가 '1' 또는 '2'가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"3", "a", "", " ", "12"})
    void validateRestartCommand_Exception(String input) {
        assertThatThrownBy(() -> Validator.validateRestartCommand(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1 또는 2만 입력해야 합니다.");
    }

    @DisplayName("정상적인 재시작 명령어인 경우 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void validateRestartCommand_Success(String input) {
        assertThatCode(() -> Validator.validateRestartCommand(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("숫자 야구 입력값이 1-9 사이의 숫자가 아니거나 문자가 포함되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"012", "a12", "1 2", "1.2", ""})
    void validateInput_NotNumeric_Exception(String input) {
        assertThatThrownBy(() -> Validator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력 가능합니다.");
    }

    @DisplayName("숫자 야구 입력값이 3자리가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"12", "1234"}) // ""(빈 문자열) 제거
    void validateInput_Length_Exception(String input) {
        assertThatThrownBy(() -> Validator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 3자리 숫자여야 합니다.");
    }

    @DisplayName("숫자 야구 입력값에 중복된 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"112", "121", "222"})
    void validateInput_Duplicate_Exception(String input) {
        assertThatThrownBy(() -> Validator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 숫자가 있습니다.");
    }

    @DisplayName("올바른 숫자 야구 입력값인 경우 예외가 발생하지 않는다.")
    @Test
    void validateInput_Success() {
        assertThatCode(() -> Validator.validateInput("123"))
                .doesNotThrowAnyException();
    }
}