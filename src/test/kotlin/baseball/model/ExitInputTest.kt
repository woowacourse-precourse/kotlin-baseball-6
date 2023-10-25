package baseball.model

import baseball.assertEqualsThrowsMessage
import baseball.model.validator.Validator
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class ExitInputTest {

    @Test
    @DisplayName("1을 입력했을 때, false 반환")
    fun isExit_whenInputRestart() {
        assertEquals(ExitInput("1").isExit(), false)
    }

    @Test
    @DisplayName("2를 입력했을 때, true 반환")
    fun isExit_whenInputExit() {
        assertEquals(ExitInput("2").isExit(), true)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "123", "가"])
    @DisplayName("기타 다른 값을 입력했을 때, 오류 메시지 반환")
    fun isExit_whenInputAnother(input: String) {
        assertEqualsThrowsMessage<IllegalArgumentException>(Validator.ErrorType.InvalidExitInput.message) {
            ExitInput(input)
        }
    }
}