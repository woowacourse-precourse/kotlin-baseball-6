package baseball.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BallNumberTest {

    @DisplayName("1~9 범위의 수로 BallNumber를 생성할 수 있다")
    @Test
    fun createBallNumberTest() {
        // given
        val input = 1

        // when
        val ballNumber = BallNumber(1)

        // then
        assertThat(ballNumber.ballNumber).isEqualTo(1)
    }

    @DisplayName("1~9 범위의 수가 아니라면 BallNumber를 생성 시 예외가 발생한다")
    @Test
    fun createBallNumberFailureTest() {
        // given
        val input1 = 0
        val input2 = 10

        // when
        // then
        assertThatThrownBy { BallNumber(input1) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("BallNumber는 1~9 사이의 숫자만 가능합니다.")

        assertThatThrownBy { BallNumber(input2) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("BallNumber는 1~9 사이의 숫자만 가능합니다.")
    }
}