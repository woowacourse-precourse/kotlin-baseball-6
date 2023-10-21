package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.random.Random


class RandomTargetGeneratorTest{

    @Test
    fun `랜덤으로 생성된 타겟은 세 개의 숫자여야 한다`(){
        //given
        val randomTargetGenerator = RandomTargetGenerator()

        //when
        val actual = randomTargetGenerator.generateRandomTarget()

        //then
        assertThat(actual).hasSize(3)
    }

    @Test
    fun `랜덤으로 생성된 세 개의 숫자는 모두 다른 숫자여야 한다`(){
        //given
        val randomTargetGenerator = RandomTargetGenerator()

        //when
        val actual = randomTargetGenerator.generateRandomTarget().toSet().size

        //then
        val expected = 3
        assertThat(actual).isEqualTo(expected)
    }
}