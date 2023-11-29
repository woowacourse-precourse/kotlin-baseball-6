package baseball.model

import baseball.model.BaseballNumbers.Companion.INVALID_NUMBERS_SIZE
import baseball.model.BaseballNumbers.Companion.NUMBERS_DUPLICATED
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class BaseballNumbersTest {
    @ParameterizedTest
    @MethodSource("provideInvalidCountBaseballNumbers")
    fun `게임에 사용되는 숫자 셋은 세자리가 아니면 예외를 던진다`(baseballNumbers: List<BaseballNumber>) {
        val exception = assertThrows<IllegalArgumentException> {
            BaseballNumbers(baseballNumbers)
        }
        assertThat(exception.message).isEqualTo(INVALID_NUMBERS_SIZE)
    }

    @ParameterizedTest
    @MethodSource("provideDuplicatedBaseballNumbers")
    fun `게임에 사용되는 숫자 셋에는 중복이 있으면 예외를 던진다`(baseballNumbers: List<BaseballNumber>) {
        val exception = assertThrows<IllegalArgumentException> {
            BaseballNumbers(baseballNumbers)
        }
        assertThat(exception.message).isEqualTo(NUMBERS_DUPLICATED)
    }

    @ParameterizedTest
    @MethodSource("provideNormalBaseballNumbers")
    fun `세자리 중복이 없는 숫자 셋의 경우 정상이다`(baseballNumbers: List<BaseballNumber>) {
        assertDoesNotThrow {
            BaseballNumbers(baseballNumbers)
        }
    }

    companion object {
        @JvmStatic
        fun provideInvalidCountBaseballNumbers(): Stream<List<BaseballNumber>> = Stream.of(
            listOf(),
            listOf(BaseballNumber(1)),
            listOf(BaseballNumber(1), BaseballNumber(2)),
            listOf(BaseballNumber(1), BaseballNumber(2), BaseballNumber(3), BaseballNumber(4)),
        )

        @JvmStatic
        fun provideDuplicatedBaseballNumbers(): Stream<List<BaseballNumber>> = Stream.of(
            listOf(BaseballNumber(1), BaseballNumber(1), BaseballNumber(1)),
            listOf(BaseballNumber(1), BaseballNumber(3), BaseballNumber(3)),
            listOf(BaseballNumber(9), BaseballNumber(3), BaseballNumber(9)),
        )

        @JvmStatic
        fun provideNormalBaseballNumbers(): Stream<List<BaseballNumber>> = Stream.of(
            listOf(BaseballNumber(1), BaseballNumber(2), BaseballNumber(3)),
            listOf(BaseballNumber(1), BaseballNumber(3), BaseballNumber(7)),
            listOf(BaseballNumber(9), BaseballNumber(3), BaseballNumber(1)),
        )
    }

}