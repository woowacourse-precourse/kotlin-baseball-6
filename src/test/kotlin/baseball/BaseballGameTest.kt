package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BaseballGameTest {
    private val game = BaseballGame()
    private var userInput = ""

    @Nested
    inner class NumbersTest {
        @Test
        fun `컴퓨터의 랜덤 값이 3자리인지 테스트`() {
            val computerNumbers = game.generateRandomNumbers()
            assertThat(computerNumbers).hasSize(3)
        }

        @Test
        fun `컴퓨터의 랜덤 값이 중복되었는지 테스트`() {
            val computerNumbers = game.generateRandomNumbers()
            computerNumbers.toHashSet()
            assertThat(computerNumbers).hasSize(3)
        }

        @Test
        fun `사용자의 야구 숫자 입력 값이 숫자 아닌 다른 형식일 때 예외 테스트`() {
            userInput = "12Q"
            assertThrows<IllegalArgumentException> { (validateUserNumbers(userInput)) }
        }

        @Test
        fun `사용자의 야구 숫자 입력 값이 범위를 초과하였을 때 예외 테스트`() {
            userInput = "1234"
            assertThrows<IllegalArgumentException> { (validateUserNumbers(userInput)) }
        }

        @Test
        fun `사용자의 야구 숫자 입력 값이 범위보다 작을 때 예외 테스트`() {
            userInput = "12"
            assertThrows<IllegalArgumentException> { (validateUserNumbers(userInput)) }
        }

        @Test
        fun `사용자의 야구 숫자 입력 값이 중복되었을 때 예외 테스트`() {
            userInput = "122"
            assertThrows<IllegalArgumentException> { (validateUserNumbers(userInput)) }
        }
    }

    @Nested
    inner class CompareNumbersTest() {
        @Test
        fun `컴퓨터와 사용자의 숫자를 비교하여 결과 확인 - 낫싱`() {
            val computerNumbers = listOf(1, 2, 3)
            val userNumbers = listOf(4, 5, 6)
            val result = Pair(0, 0)
            assertThat(result).isEqualTo(game.compareNumbers(computerNumbers, userNumbers))
        }

        @Test
        fun `컴퓨터와 사용자의 숫자를 비교하여 결과 확인 - 3스트라이크`() {
            val computerNumbers = listOf(1, 2, 3)
            val userNumbers = listOf(1, 2, 3)
            val result = Pair(0, 3)
            assertThat(result).isEqualTo(game.compareNumbers(computerNumbers, userNumbers))
        }

        @Test
        fun `컴퓨터와 사용자의 숫자를 비교하여 결과 확인 - 2볼`() {
            val computerNumbers = listOf(1, 2, 3)
            val userNumbers = listOf(2, 3, 4)
            val result = Pair(2, 0)
            assertThat(result).isEqualTo(game.compareNumbers(computerNumbers, userNumbers))
        }
    }

    @Nested
    inner class HintMessageTest {
        @Test
        fun `낫싱 테스트`() {
            val result = Pair(0, 0)
            val hintMessage = "낫싱"
            assertThat(hintMessage).isEqualTo(game.provideHintMessage(result))
        }

        @Test
        fun `볼 테스트`() {
            val result = Pair(2, 0)
            val hintMessage = "2볼"
            assertThat(hintMessage).isEqualTo(game.provideHintMessage(result))
        }

        @Test
        fun `스트라이크 테스트`() {
            val result = Pair(0, 2)
            val hintMessage = "2스트라이크"
            assertThat(hintMessage).isEqualTo(game.provideHintMessage(result))
        }

        @Test
        fun `볼과 스트라이크 테스트`() {
            val result = Pair(2, 1)
            val hintMessage = "2볼 1스트라이크"
            assertThat(hintMessage).isEqualTo(game.provideHintMessage(result))
        }
    }

    @Nested
    inner class UserAnswerTest() {
        @Test
        fun `사용자의 답변 입력 값이 숫자가 아닐 때 예외 테스트`() {
            userInput = "T"
            assertThrows<IllegalArgumentException> { (validateUserAnswer(userInput)) }
        }

        @Test
        fun `사용자의 답변 입력 값이 범위를 벗어났을 때 예외 테스트`() {
            userInput = "0"
            assertThrows<IllegalArgumentException> { (validateUserAnswer(userInput)) }
        }
    }
}