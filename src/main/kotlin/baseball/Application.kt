package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun printStartGameSentence() {
    println("숫자 야구 게임을 시작합니다.")
}

fun startGame() {
    startGameUser(getAnswerNumber())
}

fun startGameUser(answerNumber: String) {
    //answerNumber를 게임 시작 시 인자로 넘겨줌
}

fun getAnswerNumber(): String {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    //joinToString(separator,prefix,postfix,limit,truncated,transform)
    return computer.joinToString(separator = "")
}

fun main() {
    printStartGameSentence()
    //게임시작
    startGame()
}