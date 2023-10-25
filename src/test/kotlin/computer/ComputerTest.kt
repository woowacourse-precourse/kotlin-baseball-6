package computer

import org.junit.jupiter.api.BeforeEach
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
}