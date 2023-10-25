package baseball.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class AnswerTest {

    @DisplayName("Answer와 일치하는 Guess를 비교하면 3스트라이크를 결과로 얻는다")
    @Test
    fun compareToGuessWithEqualNumbersTest() {
        // given
        val fixedNumberPicker = FixedNumberPicker(1, 2, 3)
        val answerCreator = AnswerCreator(fixedNumberPicker)
        val answer = answerCreator.create()

        val guess = Guess(
            listOf(
                BallNumber(1),
                BallNumber(2),
                BallNumber(3),
            ),
        )

        // when
        val strikeCount = answer.countStrikes(guess)
        val ballCount = answer.countBalls(guess)

        // then
        assertThat(strikeCount).isEqualTo(3)
        assertThat(ballCount).isEqualTo(0)
    }

    @DisplayName("Answer에 존재하지만 index는 다른 3개의 BallNumber를 가진 Guess를 비교하면 3볼을 결과로 얻는다")
    @Test
    fun compareToGuessContainedAtDifferentIndicesNumbersTest() {
        // given
        val fixedNumberPicker = FixedNumberPicker(1, 2, 3)
        val answerCreator = AnswerCreator(fixedNumberPicker)
        val answer = answerCreator.create()

        val guess = Guess(
            listOf(
                BallNumber(3),
                BallNumber(1),
                BallNumber(2),
            ),
        )

        // when
        val strikeCount = answer.countStrikes(guess)
        val ballCount = answer.countBalls(guess)

        // then
        assertThat(strikeCount).isEqualTo(0)
        assertThat(ballCount).isEqualTo(3)
    }

    @DisplayName("Answer와 Guess 간에 일치하는 BallNumber가 없는 경우 ball, strike는 모두 0이 된다.")
    @Test
    fun nothingTest() {
        // given
        val fixedNumberPicker = FixedNumberPicker(1, 2, 3)
        val answerCreator = AnswerCreator(fixedNumberPicker)
        val answer = answerCreator.create()

        val guess = Guess(
            listOf(
                BallNumber(4),
                BallNumber(5),
                BallNumber(6),
            ),
        )

        // when
        val strikeCount = answer.countStrikes(guess)
        val ballCount = answer.countBalls(guess)

        // then
        assertThat(strikeCount).isEqualTo(0)
        assertThat(ballCount).isEqualTo(0)
    }
}