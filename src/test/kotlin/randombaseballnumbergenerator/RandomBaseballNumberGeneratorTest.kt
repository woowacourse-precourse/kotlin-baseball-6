package randombaseballnumbergenerator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
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

    @RepeatedTest(100)
    fun `랜덤 야구 숫자가 전부 숫자인지`() {
        val result = randomBaseballNumberGenerator.generateRandomBaseballNumber()
            .all { it in BASEBALL_NUMBER_MINIMUM_NUMBER..BASEBALL_NUMBER_MAXIMUM_NUMBER }

        assertTrue(result)
    }

    @RepeatedTest(100)
    fun `랜덤 야구 숫자가 전부 다른 숫자인지`() {
        val result = randomBaseballNumberGenerator.generateRandomBaseballNumber().toSet().size

        assertEquals(result, BASEBALL_NUMBER_SIZE)
    }

    companion object {
        const val BASEBALL_NUMBER_SIZE = 3
        const val BASEBALL_NUMBER_MINIMUM_NUMBER = '1'
        const val BASEBALL_NUMBER_MAXIMUM_NUMBER = '9'
    }
}