package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UmpireTest {
    @Test
    fun `낫싱을 판정할 수 있다`() {
        val umpire = Umpire()
        val gameNumbers = GameNumbers("123")
        val otherGameNumbers = GameNumbers("456")

        val ballCount = umpire.judge(gameNumbers, otherGameNumbers)

        assertThat(ballCount).isEqualTo(BallCount(strike = 0, ball = 0))
    }

    @Test
    fun `스트라이크를 판정할 수 있다`() {
        val umpire = Umpire()
        val gameNumbers = GameNumbers("123")
        val otherGameNumbers = GameNumbers("156")

        val ballCount = umpire.judge(gameNumbers, otherGameNumbers)

        assertThat(ballCount).isEqualTo(BallCount(strike = 1, ball = 0))
    }

    @Test
    fun `볼을 판정할 수 있다`() {
        val umpire = Umpire()
        val gameNumbers = GameNumbers("123")
        val otherGameNumbers = GameNumbers("516")

        val ballCount = umpire.judge(gameNumbers, otherGameNumbers)

        assertThat(ballCount).isEqualTo(BallCount(strike = 0, ball = 1))
    }

    @Test
    fun `스트라이크와 볼을 판정할 수 있다`() {
        val umpire = Umpire()
        val gameNumbers = GameNumbers("123")
        val otherGameNumbers = GameNumbers("132")

        val ballCount = umpire.judge(gameNumbers, otherGameNumbers)

        assertThat(ballCount).isEqualTo(BallCount(strike = 1, ball = 2))
    }

    @Test
    fun `3스트라이크를 판정할 수 있다`() {
        val umpire = Umpire()
        val gameNumbers = GameNumbers("123")
        val otherGameNumbers = GameNumbers("123")

        val ballCount = umpire.judge(gameNumbers, otherGameNumbers)

        assertThat(ballCount).isEqualTo(BallCount(strike = 3, ball = 0))
    }
}