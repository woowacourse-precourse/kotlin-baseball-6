package baseball.controller

import baseball.model.BaseballNumber
import baseball.model.BaseballNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class NumbersConverterTest {

    @ParameterizedTest
    @CsvSource("123, 1, 2, 3", "324, 3, 2, 4", "281, 2, 8, 1")
    fun `입력받은 수를 게임의 숫자 셋으로 변환한다`(inputNumber: Int, firstDigit: Int, secondDigit: Int, thirdDigit: Int) {
        val expected = BaseballNumbers(
            listOf(
                BaseballNumber(firstDigit), BaseballNumber(secondDigit), BaseballNumber(thirdDigit)
            )
        )

        val result = inputNumber.toBaseballNumbers()
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(ints = [-10, -9, -1, 0])
    fun `입력받은 수가 0 이하이면, 예외를 던진다`(inputNumber: Int) {
        val exception = assertThrows<IllegalArgumentException> {
            inputNumber.toBaseballNumbers()
        }
        assertThat(exception.message).isEqualTo(INVALID_NUMBERS)
    }
}