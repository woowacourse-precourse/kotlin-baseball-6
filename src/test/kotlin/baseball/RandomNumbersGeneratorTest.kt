package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test

class RandomNumbersGeneratorTest {

    @Test
    @RepeatedTest(100)
    fun `반복 테스트`() {
        val randomNumbersGenerator = RandomNumbersGenerator()

        val randomNumbers = randomNumbersGenerator.generate()

        randomNumbers.forEach { assertThat(it).isBetween(1, 9) }
        assertThat(randomNumbers.toSet().size).isEqualTo(3)
    }
}
