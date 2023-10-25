package baseball
import camp.nextstep.edu.missionutils.Console

class GameController(private val view: GameView, private val model: Model) {
    fun startGame() {
        while(true) {
            playGame()
            if(!restartGame()) break
        }
    }

    private fun playGame() {
        model.modelInit()
        while(true) {
            model.userNumber = view.inputNumberView()
            val hint = compareNumber(model.userNumber, model.answerNumber)
            view.hintView(hint.first, hint.second)
            if(hint.first == 3) {

            }
        }
    }

    private fun restartGame() : Boolean {
        val restartInput = view.restartInputView()
        return restartInput == "1"
    }

    private fun compareNumber(input: String, answer: String) : Pair<Int, Int> {
        var ball = 0;
        var strike = 0;

        for(i in input.indices) {
            if (input[i] == answer[i]) strike++
            if (input[i] != answer[i] && input[i] in answer) ball++
        }

        return Pair(strike, ball)
    }
}