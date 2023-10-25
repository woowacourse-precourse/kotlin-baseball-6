package computer

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import randombaseballnumbergenerator.RandomBaseballNumberGenerator
import randombaseballnumbergenerator.RandomBaseballNumberGeneratorImpl

class ComputerTest {
    private lateinit var randomBaseballNumberGenerator: RandomBaseballNumberGenerator
    private lateinit var computer: Computer

    @BeforeEach
    fun setUp() {
        randomBaseballNumberGenerator = RandomBaseballNumberGeneratorImpl
        computer = ComputerImpl(randomBaseballNumberGenerator)
    }

    @Test
    fun `랜덤 야구 숫자 길이가 3인지`() {
        computer.setRandomBaseballNumber()
        val result = computer.randomBaseballNumber.length

        assertEquals(result, BASEBALL_NUMBER_SIZE)
    }

    @Test
    fun `랜덤 야구 숫자가 전부 숫자인지`() {
        computer.setRandomBaseballNumber()
        val result = computer
            .randomBaseballNumber
            .all { it in BASEBALL_NUMBER_MINIMUM_NUMBER..BASEBALL_NUMBER_MAXIMUM_NUMBER }

        assertTrue(result)
    }

    companion object {
        const val BASEBALL_NUMBER_SIZE = 3
        const val BASEBALL_NUMBER_MINIMUM_NUMBER = '1'
        const val BASEBALL_NUMBER_MAXIMUM_NUMBER = '9'
    }
}