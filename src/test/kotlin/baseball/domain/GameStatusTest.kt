package baseball.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class GameStatusTest {

    @DisplayName("문자열 1, 2로 GameStatus를 생성할 수 있다")
    @Test
    fun createGameStatusTest() {
        // given
        val input1 = "1"
        val input2 = "2"

        // when
        val status1 = GameStatus.of(input1)
        val status2 = GameStatus.of(input2)

        // then
        assertThat(status1).isEqualTo(GameStatus.REPLAY)
        assertThat(status2).isEqualTo(GameStatus.EXIT)
    }

    @DisplayName("문자열 1, 2외의 값으로 생성하면 UNKNOWN 상태가 된다")
    @Test
    fun createUnknownGameStatusTest() {
        // given
        val input1 = "X"
        val input2 = "O"

        // when
        val status1 = GameStatus.of(input1)
        val status2 = GameStatus.of(input2)

        // then
        assertThat(status1).isEqualTo(GameStatus.UNKNOWN)
        assertThat(status2).isEqualTo(GameStatus.UNKNOWN)
    }
}