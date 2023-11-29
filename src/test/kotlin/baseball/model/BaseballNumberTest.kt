package baseball.model

import baseball.model.BaseballNumber.Companion.INVALID_NUMBER_RANGE
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BaseballNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [0, -1, 10, 100])
    fun `사용자가 입력한 숫자가 1~9 가 아니면 예외를 던진다`(inputNumber: Int) {
        val exception = assertThrows<IllegalArgumentException> {
            BaseballNumber(inputNumber)
        }
        assertThat(exception.message).isEqualTo(INVALID_NUMBER_RANGE)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9])
    fun `사용자가 입력한 숫자가 1~9 가 이면 정상이다`(inputNumber: Int) {
        assertDoesNotThrow {
            BaseballNumber(inputNumber)
        }
    }
}