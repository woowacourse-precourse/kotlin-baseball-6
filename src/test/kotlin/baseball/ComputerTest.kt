package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ComputerTest {
    @Test
    fun `BallNumbers를 생성한다`() {
        val numberGenerator = NumberGenerator { mutableListOf(1, 2, 3) }

        val computer = Computer(numberGenerator)

        assertThat(computer.getGameNumbers()).isEqualTo(GameNumbers("123"))
    }

    @Test
    fun `BallNumbers를 변경한다`() {
        val computer = Computer()
        val originalGameNumbers = computer.getGameNumbers()

        computer.changeGameNumbers()
        val newGameNumbers = computer.getGameNumbers()

        assertThat(newGameNumbers).isNotEqualTo(originalGameNumbers)
    }
}
