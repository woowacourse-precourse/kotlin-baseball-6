package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BallCountTest {
    @Test
    fun `비교결과가 낫싱이다`() {
        val ballCount = BallCount(0, 0)

        assertThat(ballCount.getMessage()).isEqualTo("낫싱")
    }

    @Test
    fun `비교결과가 3스트라이크이다`() {
        val ballCount = BallCount(3, 0)

        assertThat(ballCount.isThreeStrike()).isTrue()
        assertThat(ballCount.getMessage()).isEqualTo("3스트라이크")
    }

    @Test
    fun `비교결과가 스트라이크만 있는 경우`() {
        val ballCount = BallCount(1, 0)

        assertThat(ballCount.getMessage()).isEqualTo("1스트라이크")
    }

    @Test
    fun `비교결과가 볼만 있는 경우`() {
        val ballCount = BallCount(0, 2)

        assertThat(ballCount.getMessage()).isEqualTo("2볼")
    }

    @Test
    fun `비교결과가 스트라이크와 볼 모두 있는 경우`() {
        val ballCount = BallCount(1, 2)

        assertThat(ballCount.isThreeStrike()).isFalse()
        assertThat(ballCount.getMessage()).isEqualTo("2볼 1스트라이크")
    }
}
