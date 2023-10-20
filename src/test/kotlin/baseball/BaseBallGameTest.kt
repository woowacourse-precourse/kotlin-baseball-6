package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BaseBallGameTest {
    private val game = BaseBallGame()
    private var userInput = ""
    @Test
    fun `컴퓨터 숫자 크기 테스트`() {
        val computerNumbers = game.generateRandomNumbers()
        assertThat(computerNumbers).hasSize(3)
    }

    @Test
    fun `컴퓨터 숫자 중복 테스트`() {
        val computerNumbers = game.generateRandomNumbers()
        computerNumbers.toHashSet()
        assertThat(computerNumbers).hasSize(3)
    }

    @Test
    fun `사용자의 입력 값이 숫자가 아닌 다른 형식일 때 예외 테스트`() {
        userInput = "12Q"
        assertThrows<IllegalArgumentException> { (game.validateUserNumbers(userInput)) }
    }

    @Test
    fun `사용자의 입력 값이 범위를 초과하였을 때 예외 테스트`() {
        userInput = "1234"
        assertThrows<IllegalArgumentException> { (game.validateUserNumbers(userInput)) }
    }

    @Test
    fun `사용자의 입력 값이 범위보다 작을 때 예외 테스트`() {
        userInput = "12"
        assertThrows<IllegalArgumentException> { (game.validateUserNumbers(userInput)) }
    }

    @Test
    fun `사용자의 입력 값이 중복되었을 때 예외 테스트`() {
        userInput = "122"
        assertThrows<IllegalArgumentException> { (game.validateUserNumbers(userInput)) }
    }
}