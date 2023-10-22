package baseball

import baseball.model.NumberPicker
import baseball.model.Referee
import baseball.model.UserNumber

class Controller {

    private val keepPlaying = true
    fun startGame() {
        while (keepPlaying) {
            playGame()
            // todo 계속할 것인지 여부 묻기
        }
    }

    private fun playGame() {
        val answer = NumberPicker().pickRandomNumber()
        while (true) {
            val userNumber = UserNumber(listOf(1, 2, 3)) // todo 입력 받기
            val isCorrect: Boolean = Referee().judge(userNumber, answer)
            if (isCorrect) break
        }
    }
}
