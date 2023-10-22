package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BallCountTest {
    @Test
    fun `비교결과가 낫싱이다`() {
        val ballCount = BallCount(0, 0)

        assertThat(ballCount.isNothing()).isTrue()
    }

    @Test
    fun `비교결과가 낫싱이 아니다`() {
        val ballCount = BallCount(1, 0)

        assertThat(ballCount.isNothing()).isFalse()
    }

    @Test
    fun `비교결과가 3스트라이크이다`() {
        val ballCount = BallCount(3, 0)

        assertThat(ballCount.isThreeStrike()).isTrue()
    }

    @Test
    fun `비교결과가 3스트라이크가 아니다`() {
        val ballCount = BallCount(2, 0)

        assertThat(ballCount.isThreeStrike()).isFalse()
    }
}