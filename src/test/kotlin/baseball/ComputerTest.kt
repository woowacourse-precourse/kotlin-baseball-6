package baseball

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class ComputerTest {
    private lateinit var computer: Computer

    @BeforeEach
    fun setUp() {
        computer = Computer()
    }

    @Test
    fun `컴퓨터가 생성한 수에 대해 예외가 발생하지 않아야 함`() {
        assertDoesNotThrow { computer.generateNumbers() }
    }

    private fun runCalculateStrikeAndBallTest(
        userNumbers: List<Int>,
        expectedBall: Int,
        expectedStrike: Int
    ) {
        computer.setNumbersForTesting(listOf(1, 2, 3))
        val ballAndStrikeCounts = computer.calculateBallAndStrike(userNumbers)
        val ballCount = ballAndStrikeCounts.ball
        val strikeCount = ballAndStrikeCounts.strike

        assert(ballCount == expectedBall)
        assert(strikeCount == expectedStrike)
    }

    @Test
    fun `0볼 0스트라이크 테스트`() {
        runCalculateStrikeAndBallTest(
            userNumbers = listOf(4, 5, 6),
            expectedBall = 0,
            expectedStrike = 0
        )
    }

    @Test
    fun `0볼 1스트라이크 테스트`() {
        runCalculateStrikeAndBallTest(
            userNumbers = listOf(1, 4, 5),
            expectedBall = 0,
            expectedStrike = 1
        )
    }

    @Test
    fun `0볼 2스트라이크 테스트`() {
        runCalculateStrikeAndBallTest(
            userNumbers = listOf(1, 2, 4),
            expectedBall = 0,
            expectedStrike = 2
        )
    }

    @Test
    fun `0볼 3스트라이크 테스트`() {
        runCalculateStrikeAndBallTest(
            userNumbers = listOf(1, 2, 3),
            expectedBall = 0,
            expectedStrike = 3
        )
    }

    @Test
    fun `1볼 0스트라이크 테스트`() {
        runCalculateStrikeAndBallTest(
            userNumbers = listOf(4, 5, 2),
            expectedBall = 1,
            expectedStrike = 0
        )
    }

    @Test
    fun `1볼 1스트라이크 테스트`() {
        runCalculateStrikeAndBallTest(
            userNumbers = listOf(1, 3, 4),
            expectedBall = 1,
            expectedStrike = 1
        )
    }

    @Test
    fun `2볼 0스트라이크 테스트`() {
        runCalculateStrikeAndBallTest(
            userNumbers = listOf(3, 5, 2),
            expectedBall = 2,
            expectedStrike = 0
        )
    }

    @Test
    fun `2볼 1스트라이크 테스트`() {
        runCalculateStrikeAndBallTest(
            userNumbers = listOf(1, 3, 2),
            expectedBall = 2,
            expectedStrike = 1
        )
    }

    @Test
    fun `3볼 0스트라이크 테스트`() {
        runCalculateStrikeAndBallTest(
            userNumbers = listOf(3, 1, 2),
            expectedBall = 3,
            expectedStrike = 0
        )
    }
}