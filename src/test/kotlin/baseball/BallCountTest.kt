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
}