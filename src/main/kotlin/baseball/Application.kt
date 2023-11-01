package baseball

import baseball.Util.Validator.validateGameStatus
import baseball.Util.Validator.validateInteger
import baseball.Util.Validator.validateLength
import baseball.Util.Validator.validateRange
import baseball.Util.Validator.validateUniqueNumber
import baseball.View.InputView
import baseball.View.OutputView
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    outputView.printGameStart()
    var computerNumber = setComputerNumber()

    while (true) {
        val userNumber = inputView.getUserInputList()
        val hint = compareNumber(computerNumber, userNumber)
        outputView.printHint(hint)
        if (hint.first == 3) {
            outputView.printGameEndMessage()
            val status = inputView.decideGameStatus()
            if (status == 1) {
                computerNumber = setComputerNumber()
            } else {
                break
            }
        }
    }
}

fun setComputerNumber(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.toList()
}

fun makeIntList(number: String): List<Int> {
    return number.map { it.digitToInt() }.toList()
}

fun compareNumber(computer: List<Int>, user: List<Int>): Pair<Int, Int> {
    var strike = 0
    var ball = 0

    for (i in user.indices) {
        if (computer[i] == user[i]) {
            strike++
        } else if (computer.contains(user[i])) {
            ball++
        }
    }
    return Pair(strike, ball)
}