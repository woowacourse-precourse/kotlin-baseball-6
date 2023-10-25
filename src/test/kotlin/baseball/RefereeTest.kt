package baseball

import org.junit.jupiter.api.Test

class RefereeTest {
    private val referee = Referee()

    @Test
    fun `볼 카운트 판정 테스트`() {
        val pitcherNumbers: List<Int> = listOf(1, 4, 3)
        val batterNumbers: List<Int> = listOf(3, 2, 1)
        val expected = "2볼"

        referee.judge(pitcherNumbers, batterNumbers)
        println(referee.getResultMessage())
        assert(expected == referee.getResultMessage())
    }

    @Test
    fun `스트라이크 카운트 판정 테스트`() {
        val pitcherNumbers: List<Int> = listOf(2, 4, 7)
        val batterNumbers: List<Int> = listOf(1, 3, 7)
        val expected = "1스트라이크"

        referee.judge(pitcherNumbers, batterNumbers)
        assert(expected == referee.getResultMessage())
    }

    @Test
    fun `낫싱 판정 테스트`() {
        val pitcherNumbers: List<Int> = listOf(1, 2, 3)
        val batterNumbers: List<Int> = listOf(4, 5, 6)
        val expected = "낫싱"

        referee.judge(pitcherNumbers, batterNumbers)
        assert(expected == referee.getResultMessage())
    }
}