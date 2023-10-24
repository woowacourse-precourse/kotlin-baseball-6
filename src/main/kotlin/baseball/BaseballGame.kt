package baseball

import camp.nextstep.edu.missionutils.Console
import util.Constants

class BaseballGame {

    fun startBaseballGame() {
        println(Constants.START_MESSAGE)
        do {
            playBaseballGame()
        } while (isRestartable())
    }

    fun playBaseballGame() {
        val answerNumbers = creatRandomNumbers()
//    println(answerNumbers) // 랜덤 생성된 정답 미리보기
        do {
            val userNumbers = getUserInput()
            printScore(answerNumbers, userNumbers)
        } while (!isSame(answerNumbers, userNumbers))
        println(Constants.SUCCESS_MESSAGE)
    }


    fun isRestartable(): Boolean {
        println(Constants.RESTART_MESSAGE)
        val restartChar = Console.readLine()
        return ("1" == restartChar)
    }

    fun printScore(answerNumbers: List<Int>, userNumbers: List<Int>) {
        var strikeCount = 0
        var ballCount = 0
        for (i in answerNumbers.indices) {
            if (userNumbers[i] == answerNumbers[i]) strikeCount++
            else if (answerNumbers.contains(userNumbers[i])) ballCount++
        }
        val strikeMessage = if (0 < strikeCount) "${strikeCount}스트라이크" else ""
        val ballMessage = if (0 < ballCount) "${ballCount}볼 " else ""
        val scoreMessage = if (strikeCount == 0 && ballCount == 0) "낫싱" else "$ballMessage$strikeMessage"
        println(scoreMessage)
    }

    fun isSame(answer: List<Int>, user: List<Int>) = answer == user
}