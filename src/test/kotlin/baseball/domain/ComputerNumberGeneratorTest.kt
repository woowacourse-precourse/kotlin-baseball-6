package baseball.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.RepeatedTest

class ComputerNumberGeneratorTest {

    @RepeatedTest(100)
    fun `정상적인 컴퓨터 숫자 생성 테스트`() {
        val input = ComputerNumberGenerator.generate()

        assertThat(input)
            .hasSize(3)
            .allMatch { it in 1..9 }
            .doesNotHaveDuplicates()
    }
}