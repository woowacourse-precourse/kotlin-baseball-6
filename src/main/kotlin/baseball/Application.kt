package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

/*
기능명세
컴퓨터 : 랜덤 수 3개를 뽑는다 - 사용자가 맞추기 전까지 바뀌지 않음

게임(숫자를 비교한다) :
1/ 3자리수를 다 맞춘경우
    1,2를 입력해서 재시작/종료를 구분
2/ 3자리수를 다 맞추지 못한 경우
    1. 스트라이크 - 같은 자리에 있으면
    2. 볼    - 다른 자리에 있으면
    3. 낫싱인경우    - 같은 수가 전혀 없으면

사람 : 0~9까지의 숫자 중에서 3개를 입력받는다.
 */

fun main() {
    Game().gameStart()
}

class Computer() {

    fun randomNum(): MutableList<Int> {
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer
    }
}

class User() {

    /*
    입력한 값이 이상한 경우 Illegal반환
    자릿수가 3개가 아닌경우, 1~9가 아닌경우, 숫자가 아닌경, 중복된 숫자가 들어가있는 경우
     */
    fun userInputNum(): List<Int> {
        println("숫자를 입력해주세요 : ")
        val userNum = Console.readLine().map { it.digitToInt() }
        println(userNum)
        checkNumLength(userNum)
        checkInt(userNum)
        checkOverlap(userNum)

        return userNum
    }

    private fun checkNumLength(userNum: List<Int>) {
        if (userNum.size != 3) throw IllegalArgumentException(INPUT_LENGTH_ERROR)
    }

    private fun checkInt(userNum: List<Int>) {
        if (userNum.contains(0)) throw IllegalArgumentException(INPUT_RANGE_ERROR)
    }

    private fun checkOverlap(userNum: List<Int>) {
        if (userNum.distinct().size != 3) throw IllegalArgumentException(INPUT_NUMBER_DUPLICATE)
    }

    companion object {
        const val INPUT_LENGTH_ERROR = "숫자3자리를 입력해주세요."
        const val INPUT_RANGE_ERROR = "1~9사이 값이 아닙니다."
        const val INPUT_NUMBER_DUPLICATE = "중복된 숫자가 있습니다."
    }
}

class Game() {
    fun gameStart() {
        val computerNum = Computer().randomNum()
        println(computerNum)

        while (true) {
            val userNum = User().userInputNum()
            BaseBall(userNum, computerNum).startBaseBall()
            if (BaseBall(userNum, computerNum).isMatchNumber() == BaseBall.COMPLETE) {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
                val playGame = readLine()?.toInt()
                return when (playGame) {
                    1 -> gameStart()
                    2 -> break
                    else -> throw IllegalArgumentException("1,2값이 아닙니다.")
                }
            }
        }
    }
}


class BaseBall(val userNum: List<Int>, val gameNum: MutableList<Int>) {  //입력한 값을 파라미터로 받는다
    private var strike = 0
    private var ball = 0

    fun startBaseBall() {
        checkStrike()
        checkBall()
        printBallNum()
    }

    fun isMatchNumber(): String {
        return when (userNum == gameNum) {
            true -> COMPLETE
            else -> CONTINUE
        }
    }

    private fun checkStrike() {
        for (i in userNum.indices) {
            if (userNum[i] == gameNum[i]) {
                strike++
            }
        }
    }

    private fun checkBall() {
        for (i in userNum.indices) {
            for (game in gameNum.indices) {
                if (userNum[i] == gameNum[game]) {
                    ball++
                }
            }
        }
    }


    private fun printBallNum() {
        if (ball == 0 && strike > 0) {
            println("{$strike}스트라이크")
        } else if (ball > 0 && strike == 0) {
            println("${ball}볼")
        } else if (ball > 0 && strike > 0) {
            println("${ball}볼 ${strike}스트라이크")
        } else if (userNum == gameNum) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        } else {
            println("낫싱")
        }
    }

    companion object {
        const val COMPLETE = "COMPLETE"
        const val CONTINUE = "CONTINUE"
    }
}

