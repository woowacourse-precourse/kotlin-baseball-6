package baseball.model

import baseball.model.BaseballNumbers.Companion.INVALID_NUMBERS_SIZE
import baseball.model.BaseballNumbers.Companion.NUMBERS_DUPLICATED
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BaseballNumbersTest {
    @Test
    fun `게임에 사용되는 숫자 셋은 세자리임을 검증한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            BaseballNumbers(
                listOf(
                    BaseballNumber(1), BaseballNumber(2)
                )
            )
        }
        assertThat(exception.message).isEqualTo(INVALID_NUMBERS_SIZE)
    }

    @Test
    fun `게임에 사용되는 숫자 셋에는 중복 없음을 검증한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            BaseballNumbers(
                listOf(
                    BaseballNumber(1), BaseballNumber(3), BaseballNumber(1)
                )
            )
        }
        assertThat(exception.message).isEqualTo(NUMBERS_DUPLICATED)
    }

}