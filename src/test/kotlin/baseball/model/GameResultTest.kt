package baseball.model

import org.junit.jupiter.api.Test

class GameResultTest {

    @Test
    fun `입력 값이 전부 맞을 때, isAllStrike() 함수가 true를 반환하는지`() {
        val computerAnswer = Answer("123")
        val userAnswer = Answer("123")
        assert(GameResult(computerAnswer, userAnswer).isAllStrike())
    }
}