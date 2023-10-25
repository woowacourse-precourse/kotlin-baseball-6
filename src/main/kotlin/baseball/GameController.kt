package baseball

import camp.nextstep.edu.missionutils.Console

class GameController(private val view: GameView, private val model: Model) {
    fun playGame() {

    }
    /*fun inputNumber(): String {
        view.inputNumberView()

    }
*/
    fun numberCheck(input: String) {
        require(input.length == 3) {"입력값이 3자리가 아닙니다."}
        require(input.all { it.isDigit() } && '0' !in input) {"입력값에 0이나 숫자가 아닌 값이 있습니다."}
        require(input.toSet().size == input.length) {"입력값에 중복되는 숫자가 있습니다."}
    }

    fun compareNumber(input: String, answer: String) : Pair<Int, Int> {
        var ball = 0;
        var strike = 0;

        for(i in input.indices) {
            if (input[i] == answer[i]) strike++
            if (input[i] != answer[i] && input[i] in answer) ball++
        }

        return Pair(ball, strike)
    }
}