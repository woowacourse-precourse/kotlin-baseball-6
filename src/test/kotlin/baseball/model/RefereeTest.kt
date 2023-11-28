package baseball.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource


class RefereeTest {

    @ParameterizedTest
    @CsvSource(
        "1,2,3 , 4,5,6 , 0,0 ",
        "1,2,3 , 1,2,3 , 3,0",
        "1,2,3 , 3,1,2 , 0,3",
        "1,2,3 , 1,3,2 , 1,2",
        "4,6,2 , 2,7,9 , 0,1",
    )
    fun `입력과 정답을 비교해서 결과를 알려준다`(
        inputFirst: Int, inputSecond: Int, inputThird: Int,
        answerFirst: Int, answerSecond: Int, answerThird: Int,
        strikeCount: Int, ballCount: Int
    ) {
        // given
        val inputNumbers = BaseballNumbers(
            listOf(
                BaseballNumber(inputFirst),
                BaseballNumber(inputSecond),
                BaseballNumber(inputThird)
            )
        )
        val answer = BaseballNumbers(
            listOf(
                BaseballNumber(answerFirst),
                BaseballNumber(answerSecond),
                BaseballNumber(answerThird)
            )
        )

        // when
        val result = Referee().compare(inputNumbers, answer)
        val expected = BallAndStrike(strikeCount, ballCount)

        // then
        assertThat(result).isEqualTo(expected)

    }
}