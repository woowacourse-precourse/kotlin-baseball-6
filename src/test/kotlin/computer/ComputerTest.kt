package computer

import org.junit.jupiter.api.Assertions.assertEquals
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

    companion object {
        const val BASEBALL_NUMBER_SIZE = 3
    }
}