package baseball

import baseball.model.NumberPicker
import baseball.model.Referee
import baseball.model.UserNumber

class Controller(private val view: View) {

    private var keepPlaying = true
    private val numberPicker = NumberPicker()
    private val referee = Referee()

    fun startGame() {
        view.printStartMessage()
        while (keepPlaying) {
            playGame()
            if (!view.questPlayingGame()) keepPlaying = false
        }
    }

    private fun playGame() {
        val answer = numberPicker.pickRandomNumber()
        while (true) {
            val userNumber = UserNumber(view.inputUserNumber())
            val judgeResult = referee.judge(userNumber, answer)
            view.printResult(judgeResult)
            if (judgeResult.strike == 3) {
                view.printCorrectMessage()
                break
            }
        }
    }
}
