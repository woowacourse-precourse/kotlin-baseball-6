package baseballView

import baseball.Answer
import baseballViewModel.ErrorMessage
import baseballViewModel.ValidInput
import camp.nextstep.edu.missionutils.Console

class Input {
    object PlayMent {
        const val PLAY_START_MENT = "숫자 야구 게임을 시작합니다."
        const val PLEASE_INPUT = "숫자를 입력해주세요: "
        const val END_GAME="3개의 숫자를 모두 맞히셨습니다! 게임 종료"
        const val RESET_GAME="게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    }
    object NumberLimit{
        const val ZERO=0
        const val THREE_STRIKE=3
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
        if (score.first == NumberLimit.ZERO && score.second == NumberLimit.ZERO) {
            println(Answer.NOTHING.message)
        } else if (score.first == NumberLimit.THREE_STRIKE) {
            println(Answer.THREE_STRIKE.message)
            endGame()
        } else {
            println(Answer.ANSWER.message.format(score.second, score.first))
        }
    }

    private fun endGame() {
        println(PlayMent.END_GAME)
        println(PlayMent.RESET_GAME)
    }

   fun resetGame(): Boolean {
        val inputNumber = Console.readLine().toInt()
        if (inputNumber == 1) {
            return true
        }
        if(inputNumber==2)
            return false
        if (inputNumber!=1||inputNumber!=2) {
            throw IllegalArgumentException(ErrorMessage.ONE_OR_TWO.message)
            return false
        }
        return false
    }
}
