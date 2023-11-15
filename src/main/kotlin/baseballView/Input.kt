package baseballView

import baseball.Answer
import baseballViewModel.ValidInput
import camp.nextstep.edu.missionutils.Console

class Input {
    object PlayMent {
        const val PLAY_START_MENT = "숫자 야구 게임을 시작합니다."
        const val PLEASE_INPUT = "숫자를 입력해주세요: "
    }

    private var userNumber = mutableListOf<Char>()
    private val validInput = ValidInput()

    fun readInputNumber(): String {
        println(PlayMent.PLEASE_INPUT)
        val inputNumber = Console.readLine()
        validInput.validUserNumber(inputNumber, userNumber)
        return userNumber.joinToString("")
    }

    fun printlnScore(score: Pair<Int, Int>) {
        if (score.first == 0 && score.second == 0) {
            println(Answer.NOTHING.message)
        } else if (score.first == 3) {
            println(Answer.THREE_STRIKE.message)
            endGame()
        } else {
            println(Answer.ANSWER.message.format(score.second, score.first))
        }
    }

    private fun endGame() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }

    fun resetGame(): Boolean {
        while (true) {
            try {
                val inputNumber = Console.readLine().toInt()
                when (inputNumber) {
                    1 -> return true
                    2 -> return false
                    else -> {
                        println("1 또는 2를 입력하세요.")
                    }
                }
            } catch (e: NumberFormatException) {
                println("숫자를 입력하세요.")
            }
        }
    }
}
