package randombaseballnumbergenerator

import org.junit.jupiter.api.BeforeEach

class RandomBaseballNumberGeneratorTest {
    private lateinit var randomBaseballNumberGenerator: RandomBaseballNumberGenerator

    @BeforeEach
    fun setUp() {
        randomBaseballNumberGenerator = RandomBaseballNumberGeneratorImpl
    }
}