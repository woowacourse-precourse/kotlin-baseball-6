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
    //비교하여 맞을 때까지 진행
    while(true) {
        print("숫자를 입력해주세요 : ")
        val userNumber = Console.readLine().toString()
    }
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