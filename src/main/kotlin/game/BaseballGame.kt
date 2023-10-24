package game

import camp.nextstep.edu.missionutils.Randoms
import user.User

private const val RANDOM_MIN_VALUE = 1
private const val RANDOM_MAX_VALUE = 9
private const val BASEBALL_NUMBER_COUNT = 3

class BaseballGame(private val user: User) {
    private var randomNumber: List<Int> = listOf()

    private fun getRandomNumbers(): List<Int> {
        val numberList: MutableList<Int> = mutableListOf()
        while (numberList.size < BASEBALL_NUMBER_COUNT) {
            val randomNumber = Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE)
            if (!numberList.contains(randomNumber)) numberList.add(randomNumber)
        }
        return numberList
    }

    fun isThreeStrikes(): Boolean {
        val strikeAndBallCount = getStrikeAndBallCount(randomNumber)
        return strikeAndBallCount.strike == BASEBALL_NUMBER_COUNT
    }

    fun printBaseballResultMessage(strikeAndBallCount: StrikeAndBallCount = getStrikeAndBallCount(randomNumber)) {
        with(strikeAndBallCount) {
            when {
                strike + ball == 0 -> println("낫싱")
                strike == 0 -> println("${ball}볼")
                ball == 0 -> println("${strike}스트라이크")
                else -> println("${ball}볼 ${strike}스트라이크")
            }
        }
    }

    private fun convertToNumberList(numbers: Int): List<Int> {
        return numbers.toString().map { it.toString().toInt() }
    }

    private fun getStrikeAndBallCount(randomNumber: List<Int>): StrikeAndBallCount {
        var strike = 0
        var ball = 0
        val userBaseballNumberList: List<Int> = convertToNumberList(user.currentUserBaseballNumber)
        randomNumber.forEachIndexed { index, number ->
            when {
                userBaseballNumberList[index] == number -> strike++
                randomNumber.contains(userBaseballNumberList[index]) -> ball++
            }
        }
        return StrikeAndBallCount(strike = strike, ball = ball)
    }

    fun printBaseballGameSuccessMessage() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }

    fun setNewRandomNumbers() {
        randomNumber = getRandomNumbers()
    }

    init {
        randomNumber = getRandomNumbers()
        println("숫자 야구 게임을 시작합니다.")
    }
}

data class StrikeAndBallCount(
    val strike: Int = 0,
    val ball: Int = 0
)