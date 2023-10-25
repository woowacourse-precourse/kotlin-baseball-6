package baseball

import org.junit.jupiter.api.Test

class PitcherTest {
    private val numberCount = 2
    private val minNumber = 1
    private val maxNumber = 5
    private val pitcher = Pitcher(numberCount, minNumber, maxNumber)

    @Test
    fun `난수 범위 확인`() {
        pitcher.generateNumbers()

        pitcher.getNumbers().map { number -> assert(number in minNumber..maxNumber) }
    }

    @Test
    fun `난수 개수 확인`() {
        pitcher.generateNumbers()

        assert(pitcher.getNumbers().size == numberCount)
    }

    @Test
    fun `난수 중복 여부 확인`() {
        pitcher.generateNumbers()

        assert(pitcher.getNumbers().distinct().size == pitcher.getNumbers().size)
    }
}