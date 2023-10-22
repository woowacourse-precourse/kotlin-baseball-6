package baseball

import baseball.model.NumberPicker
import baseball.model.Referee
import baseball.model.UserNumber

class Controller(private val view: View) {

    private val keepPlaying = true
    private val numberPicker = NumberPicker()
    private val referee = Referee()

    fun startGame() {
        view.printStartMessage()
        while (keepPlaying) {
            playGame()
            // todo 계속할 것인지 여부 묻기
        }
    }

    private fun playGame() {
        val answer = numberPicker.pickRandomNumber()
        while (true) {
            val userNumber = UserNumber(view.inputUserNumber())
            val isCorrect: Boolean = referee.judge(userNumber, answer)
            if (isCorrect) break
        }
    }
}
