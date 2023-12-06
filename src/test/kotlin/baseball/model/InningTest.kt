package baseball.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


class InningTest {

    private lateinit var inning: Inning

    @BeforeEach
    fun setUp() {
        // given
        val pitcherNumber = PlayingNumber.from("123")
        inning = Inning(pitcherNumber)
    }

    @Test
    @DisplayName("모든 숫자가 스트라이크인 경우")
    fun play_whenAllStrikes() {
        // when
        val score = inning.matchUp("123")

        // then
        assertThat(score.isEnd()).isTrue()
        assertThat(score.strikes).isEqualTo(3)
        assertThat(score.balls).isEqualTo(0)
    }

    @Test
    @DisplayName("")
    fun play() {
        // when
        val score = inning.matchUp("321")

        // then
        assertThat(score.strikes).isEqualTo(1)
        assertThat(score.balls).isEqualTo(2)
    }

    @Test
    @DisplayName("모든 숫자가 낫싱인경우")
    fun play_whenNothing() {
        // when
        val score = inning.matchUp("456")

        // then
        assertThat(score.isNothing()).isTrue()
        assertThat(score.strikes).isEqualTo(0)
        assertThat(score.balls).isEqualTo(0)
    }


}
