package baseball.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BallNumbersTest {
    @DisplayName("서로 다른 3자리 BallNumber로 Guess, Answer를 만들 수 있다")
    @Test
    fun createGuessWithThreeBallNumbers() {
        // given
        val ballNumbers = listOf(
            BallNumber(1),
            BallNumber(2),
            BallNumber(3),
        )

        // when
        val guess = Guess(ballNumbers)
        val answer = Answer(ballNumbers)

        assertThat(ballNumbers).isNotSameAs(ballNumbers.toList())

        // then
        assertThat(guess)
            .extracting("numbers")
            .asList()
            .containsExactly(
                BallNumber(1),
                BallNumber(2),
                BallNumber(3),
            )
//            .containsExactlyElementsOf(
//                ballNumbers.toList(),
//            )

        assertThat(answer)
            .extracting("numbers")
            .asList()
            .containsExactlyElementsOf(
                ballNumbers.toList(),
            )
    }

    @DisplayName("중복 숫자가 존재하는 3자리 BallNumber로 Guess, Answer를 생성하면 예외 발생한다")
    @Test
    fun throwsIfCreateGuessWithDuplicateBallNumbers() {

        // given
        val ballNumbers = listOf(
            BallNumber(1),
            BallNumber(1),
            BallNumber(2),
        )

        // when
        // then
        assertThatThrownBy { Guess(ballNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("BallNumbers에 중복 숫자가 존재하면 안 됩니다.")

        assertThatThrownBy { Answer(ballNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("BallNumbers에 중복 숫자가 존재하면 안 됩니다.")

    }

    @DisplayName("3자리가 아닌 BallNumber로 Guess, Answer를 생성하면 예외 발생한다")
    @Test
    fun throwsIfCreateGuessWithTwoBallNumbers() {

        // given
        val ballNumbers = listOf(
            BallNumber(1),
            BallNumber(2),
        )

        // when
        // then
        assertThatThrownBy { Guess(ballNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("BallNumbers는 3자리로 이루어진 숫자여야 합니다.")

        assertThatThrownBy { Answer(ballNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("BallNumbers는 3자리로 이루어진 숫자여야 합니다.")

    }
}