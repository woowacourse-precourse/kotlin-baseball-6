package randombaseballnumbergenerator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest

class RandomBaseballNumberGeneratorTest {
    private lateinit var randomBaseballNumberGenerator: RandomBaseballNumberGenerator

    @BeforeEach
    fun setUp() {
        randomBaseballNumberGenerator = RandomBaseballNumberGeneratorImpl
    }

    @RepeatedTest(100)
    fun `랜덤 야구 숫자 길이가 3이랑 같은지`() {
        val result = randomBaseballNumberGenerator.generateRandomBaseballNumber()

        assertEquals(result.length, BASEBALL_NUMBER_SIZE)
    }

    companion object {
        const val BASEBALL_NUMBER_SIZE = 3
    }
}