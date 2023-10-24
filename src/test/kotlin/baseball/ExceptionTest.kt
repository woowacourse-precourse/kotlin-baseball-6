package baseball

import baseball.controller.BaseballController
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExceptionTest {
    @DisplayName("3자리 인지 검사")
    @Test
    fun `checkLength`() {
        val input = "12"
        assertThrows<IllegalArgumentException> {
            BaseballController().checkLength(input)
        }
    }

    @DisplayName("서로 다른 3자리수 인지 검사")
    @Test
    fun `checkDifferentNumber`() {
        val input = "119"
        assertThrows<IllegalArgumentException> {
            BaseballController().checkDifferentNumber(input)
        }
    }

    @DisplayName("입력된 값이 1~9가 아닐 때 테스트")
    @Test
    fun `checkIsDigit`() {
        val input = "12d"
        assertThrows<IllegalArgumentException> {
            BaseballController().checkIsDigit(input)
        }
    }
}