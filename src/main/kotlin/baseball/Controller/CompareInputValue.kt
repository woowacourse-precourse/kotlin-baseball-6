package baseball.Controller

import baseball.Model.GameModel

class CompareInputValue {

    private var correctValueAndPosition = 0
    private var correctValueOnly = 0
    fun compareInputs(gameModel: GameModel): Boolean {

        val userNumbers = gameModel.userInputNumbers
        val computerNumbers = gameModel.computerNumbers

        countStrike(userNumbers, computerNumbers)
        countBall(userNumbers, computerNumbers)
        result()
        return correctValueAndPosition == 3
    }

    private fun countStrike(userNumbers: MutableList<Int>, computerNumbers: MutableList<Int>): Int {
        for (i in userNumbers.indices) {
            if (userNumbers[i] == computerNumbers[i]) {
                correctValueAndPosition++
            }
        }
        return correctValueAndPosition
    }

    private fun countBall(userNumbers: MutableList<Int>, computerNumbers: MutableList<Int>): Int {
        for (i in userNumbers.indices) {
            if (userNumbers[i] != computerNumbers[i] && computerNumbers.contains(userNumbers[i])) {
                correctValueOnly++
            }
        }
        return correctValueOnly
    }

    private fun result(){
        var result=""
        var strike=""
        var ball=""

        if (correctValueOnly > 0) {
            strike="${correctValueOnly}볼"+" "
        }
        if (correctValueAndPosition in 1..3) {
            ball="${correctValueAndPosition}스트라이크"+ " "
        }
        if (correctValueAndPosition == 0 && correctValueOnly == 0) {
            print("낫싱")
        }
        result+=strike+ball
        println(result)

    }
}
