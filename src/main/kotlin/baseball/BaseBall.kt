package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

enum class GameStatus {
    ONGOING,
    STOP
}
private const val RANDOM_START = 1
private const val RANDOM_END = 9
const val INPUT_NUMBER_COUNT = 3
const val WRONG_INPUT_MESSAGE = "잘못된 입력입니다."

class BaseBall() {
    private val checkInputRegex = Regex("^(?!.*(.).*\\1)[1-9]{$INPUT_NUMBER_COUNT}\$")
    private val findNumberRegex = Regex("([1-9])")
    private lateinit var userList: List<Int>
    private lateinit var computerList: List<Int>
    private var gameStatus = GameStatus.ONGOING

    fun startGame() {
        println("숫자 야구 게임을 시작합니다.")
        createComputerList()
        while (gameStatus == GameStatus.ONGOING) {
            print("숫자를 입력해주세요 : ")
            val input = Console.readLine()
            checkInput(input)
            insertUserList(input)
            gameStatus = printScore()
        }
    }

    private fun createComputerList() {
        val tempComputerList = mutableListOf<Int>()
        while (tempComputerList.size < INPUT_NUMBER_COUNT) {
            val randomNumber = Randoms.pickNumberInRange(RANDOM_START, RANDOM_END)
            if (randomNumber !in tempComputerList) {
                tempComputerList.add(randomNumber)
            }
        }
        computerList = tempComputerList
    }
    private fun printScore(): GameStatus {
        val countScore = countScore(computerList)
        val strike = countScore.first
        val ball = countScore.second

        return if (strike == 3) {
            println("3스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            GameStatus.STOP
        } else if (strike == 0 && ball == 0) {
            println("낫싱")
            GameStatus.ONGOING
        } else {
            println("${ball}볼 ${strike}스트라이크")
            GameStatus.ONGOING
        }
    }

    private fun countScore(computerList: List<Int>): Pair<Int, Int> {
        var strike = 0
        var ball = 0
        computerList.forEachIndexed { index, item ->
            if (item == userList[index]) {
                strike += 1
            } else if (item in userList) {
                ball += 1
            }
        }
        return Pair(strike, ball)
    }

    private fun insertUserList(input: String) {
        userList = findNumberRegex.findAll(input).map { it.groupValues[1].toInt() }.toList()
    }

    private fun checkInput(input: String) {
        if (!checkInputRegex.matches(input)) {
            throw IllegalArgumentException(WRONG_INPUT_MESSAGE)
        }
    }


}