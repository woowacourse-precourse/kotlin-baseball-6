package baseball.util

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("random number를 생성하는 class의")
class RandomNumberGeneratorTest {
    private val randomNumberGenerator = RandomNumberGenerator()

    @Test
    @DisplayName("완성된 random number 길이는 3개다")
    fun numberLength() {
        //given
        //when
        val randomNumber = randomNumberGenerator.generate()
        //then
        Assertions.assertThat(randomNumber.size).isEqualTo(3)
    }

    @Test
    @DisplayName("완성된 random number는 중복된 숫자가 없다")
    fun numberDuplicated() {
        //given
        //when
        val randomNumber = randomNumberGenerator.generate().distinct()
        //then
        Assertions.assertThat(randomNumber.size).isEqualTo(3)
    }
}