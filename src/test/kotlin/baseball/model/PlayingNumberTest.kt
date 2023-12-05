package baseball.model

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class PlayingNumberTest {

    @Nested
    inner class Constructor {

        @Test
        fun success() {
            assertThatCode { PlayingNumber(listOf(1, 2, 3)) }
                    .doesNotThrowAnyException()
        }

        @Test
        @DisplayName("2자리 숫자를 입력했을 때")
        fun wrongDigits() {
            assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
                PlayingNumber(listOf(1, 2))
            }.withMessageContaining("3자리 숫자만 입력해주세요")
        }

        @Test
        @DisplayName("중복된 숫자가 있을 때")
        fun duplicateDigits() {
            assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
                PlayingNumber(listOf(1, 1, 2))
            }.withMessageContaining("서로 다른 숫자들만 입력해주세요")
        }

        @Test
        @DisplayName("1보다 작은 숫자가 포함된 경우")
        fun outOfRangeDigits() {
            assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
                PlayingNumber(listOf(0, 4, 9))
            }.withMessageContaining("1~9 사이의 자연수만 입력해주세요")
        }

        @Test
        @DisplayName("9보다 큰 숫자가 포함된 경우")
        fun overRangeDigits() {
            assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
                PlayingNumber(listOf(10, 4, 9))
            }.withMessageContaining("1~9 사이의 자연수만 입력해주세요")
        }

    }

    @Nested
    inner class Count {
        private lateinit var computerNumber: PlayingNumber
        private lateinit var userNumber: PlayingNumber

        @BeforeEach
        fun setUp() {
            // given

            computerNumber = PlayingNumber(listOf(1, 2, 3))
            userNumber = PlayingNumber(listOf(1, 3, 2))
        }

        @Test
        fun countStrike() {
            // when
            val strikes = userNumber.countStrike(computerNumber)

            // then
            assertThat(strikes).isEqualTo(1)
        }

        @Test
        fun countBall() {
            // when
            val balls = userNumber.countBall(computerNumber)

            // then
            assertThat(balls).isEqualTo(2)
        }
    }

}
