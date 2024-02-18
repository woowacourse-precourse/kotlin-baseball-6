package baseball.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ComputerTest {

    @Test
    @DisplayName("컴퓨터 객체가 생성 되면, 지정된 자리수의 랜덤 넘버를 생성한다.")
    fun createComputerNumberTest() {
        // given
        val targetNumber = 3

        // when
        val computer = Computer(targetNumber)

        // then
        assertThat(computer.numbers.isEmpty()).isEqualTo(false)
        assertThat(computer.numbers.size).isEqualTo(targetNumber)
    }

    @Test
    @DisplayName("컴퓨터가 생성하는 랜덤 넘버는 서로 중복되지 않는다.")
    fun createComputerNumberWithNotDuplicateTest() {
        // given
        val targetNumber = 3

        // when
        val computer = Computer(targetNumber)
        val numberOne = computer.numbers[0]
        val numberTwo = computer.numbers[1]
        val numberThree = computer.numbers[2]

        // then
        assertThat(numberOne == numberTwo).isEqualTo(false)
        assertThat(numberTwo == numberThree).isEqualTo(false)
        assertThat(numberThree == numberOne).isEqualTo(false)
    }
}