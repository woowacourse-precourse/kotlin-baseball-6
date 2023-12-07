package baseball.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll


class InningTest {

    private lateinit var inning: Inning

    @BeforeEach
    fun setUp() {
        // given
        val pitcherNumber = PlayingNumber.from(THREE_STRIKES)
        inning = Inning(pitcherNumber)
    }

    @Test
    @DisplayName("모든 숫자가 스트라이크인 경우")
    fun playWhenAllStrikesThenIsEndTrue() {
        // when
        val score = inning.matchUp(THREE_STRIKES)

        // then
        assertAll(
                assertThat(score.isEnd())::isTrue,
                { assertThat(score.strikes).isEqualTo(3) },
                { assertThat(score.balls).isEqualTo(0) }
        )
    }

    @Test
    @DisplayName("1스트라이크, 2볼인 경우")
    fun play() {
        // when
        val score = inning.matchUp(ONE_STRIKE_TWO_BALLS)

        // then
        assertAll(
                { assertThat(score.strikes).isEqualTo(1) },
                { assertThat(score.balls).isEqualTo(2) }
        )

    }

    @Test
    @DisplayName("모든 숫자가 낫싱인경우")
    fun play_whenNothingThenIsNothingTrue() {
        // when
        val score = inning.matchUp(NOTHING)

        // then
        assertAll(
                assertThat(score.isNothing())::isTrue,
                { assertThat(score.strikes).isEqualTo(0) },
                { assertThat(score.balls).isEqualTo(0) }
        )
    }

    companion object {

        private const val THREE_STRIKES = "123"
        private const val ONE_STRIKE_TWO_BALLS = "321"
        private const val NOTHING = "456"
    }

}
