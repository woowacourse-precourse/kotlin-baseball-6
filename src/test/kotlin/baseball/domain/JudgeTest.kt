package baseball.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class JudgeTest {

    @Test
    @DisplayName("정답 숫자와 같지만 자리수가 다를 때, 볼이 발생한다.")
    fun judgeBallTest() {
        // given
        val judge = Judge()

        // when
        val ballCount = judge.judgeBall(3, mutableListOf(1, 2, 3), "341")

        // then
        assertThat(ballCount).isEqualTo(2)
    }

    @Test
    @DisplayName("정답 숫자와 같고, 자리수도 같을 때, 스트라이크가 발생한다.")
    fun judgeStrikeTest() {
        // given
        val judge = Judge()

        // when
        val strikeCount = judge.judgeStrike(3, mutableListOf(1, 2, 3), "124")

        // then
        assertThat(strikeCount).isEqualTo(2)
    }

    @Test
    @DisplayName("스트라이크가 랜덤 넘버 숫자와 동일하면 게임이 종료된다.")
    fun judgeNothingTest() {
        // given
        val judge = Judge()

        // when
        val isGameOver = judge.isGameOver(3, 3)

        // then
        assertThat(isGameOver).isEqualTo(true)
    }
}