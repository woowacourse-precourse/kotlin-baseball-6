package baseball

import org.junit.jupiter.api.Test

class RefereeTest {
    private val referee = Referee()

    @Test
    fun `볼 카운트 판정 테스트`() {
        val numbers: List<Int> = listOf(1, 2, 3)
        val userNumbers: List<Int> = listOf(3, 2, 1)
        val expected = 2

        referee.countBall()
        assert(referee.getBallCount() == expected)
    }

    @Test
    fun `스트라이크 카운트 판정 테스트`() {
        val numbers: List<Int> = listOf(2, 4, 7)
        val userNumbers: List<Int> = listOf(1, 3, 7)
        val expected = 1

        referee.countStrike()
        assert(referee.getStrikeCount() == expected)
    }

    @Test
    fun `낫싱 판정 테스트`() {
        val numbers: List<Int> = listOf(1, 2, 3)
        val userNumbers: List<Int> = listOf(4, 5, 6)
        val expected = true

        referee.checkNothing()
        assert(referee.getNothingOrNot() == expected)
    }
}