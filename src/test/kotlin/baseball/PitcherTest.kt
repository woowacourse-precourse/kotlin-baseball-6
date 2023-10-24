package baseball

import org.junit.jupiter.api.Test

class PitcherTest {
    private val pitcher = Pitcher(3, 1, 9)

    @Test
    fun `난수 범위 확인`() {
        pitcher.generateNumbers()

        pitcher.getNumbers().map { number -> assert(number in 1..9) }
    }

    @Test
    fun `난수 개수 확인`() {
        pitcher.generateNumbers()

        assert(pitcher.getNumbers().size == 3)
    }

    @Test
    fun `난수 중복 여부 확인`() {
        pitcher.generateNumbers()

        assert(pitcher.getNumbers().distinct().size == pitcher.getNumbers().size)
    }
}