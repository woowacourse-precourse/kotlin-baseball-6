package baseball.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


class MatchUpTest {

    private lateinit var matchUp: MatchUp

    @BeforeEach
    fun setUp() {
        // given
        val pitcherNumber = PlayingNumber.of("123")
        matchUp = MatchUp(pitcherNumber)
    }

    @Test
    @DisplayName("모든 숫자가 스트라이크인 경우")
    fun play_whenAllStrikes() {
        // when
        val score = matchUp.play("123")

        // then
        assertThat(score.isStrike()).isTrue()
        assertThat(score.strikes).isEqualTo(3)
        assertThat(score.balls).isEqualTo(0)
    }

    @Test
    @DisplayName("")
    fun play() {
        // when
        val score = matchUp.play("321")

        // then
        assertThat(score.strikes).isEqualTo(1)
        assertThat(score.balls).isEqualTo(2)
    }

    @Test
    @DisplayName("모든 숫자가 낫싱인경우")
    fun play_whenNothing() {
        // when
        val score = matchUp.play("456")

        // then
        assertThat(score.isNothing()).isTrue()
        assertThat(score.strikes).isEqualTo(0)
        assertThat(score.balls).isEqualTo(0)
    }


}
