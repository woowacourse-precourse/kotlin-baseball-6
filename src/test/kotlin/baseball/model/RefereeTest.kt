package baseball.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class RefereeTest {
    @Test
    fun `입력과 정답을 비교해서 결과를 알려준다`() {
        // given
        val inputNumbers = BaseballNumbers(
            listOf(
                BaseballNumber(3),
                BaseballNumber(6),
                BaseballNumber(2)
            )
        )
        val answer = BaseballNumbers(
            listOf(
                BaseballNumber(2),
                BaseballNumber(6),
                BaseballNumber(9)
            )
        )

        // when
        val result = Referee().compare(inputNumbers, answer)
        val expected = BallAndStrike(strikeCount = 1, ballCount = 1)

        // then
        assertThat(result).isEqualTo(expected)

    }
}