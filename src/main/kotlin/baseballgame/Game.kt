package baseballgame

import constant.Constant
import constant.StringError
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.IllegalArgumentException

class Game {
    private val comNumber = mutableListOf<Int>()// 컴퓨터 난수 저장

    init {
        while (comNumber.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!comNumber.contains(randomNumber)) {
                comNumber.add(randomNumber)
            }
        }
        println(comNumber) // 중간 확인용
    }

    private fun restart(): Boolean {
        print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ")
        val select = Console.readLine()
        return when (select) {
            "1" -> {
                true
            }

            "2" -> {
                false
            }

            else -> {
                throw IllegalArgumentException("Game.restart()에서 잘못된 입력이 발생했습니다.")
            }
        }
    }

    companion object {
        fun run() {
            do {
                val game = Game()
                game.userEnter()
            } while (game.restart())
        }
    }

    private fun userEnter() {
        do {
            print("숫자를 입력해주세요: ")
            val userNumber = Console.readLine()
            println(userNumber)
        } while (!checkStrike(userNumber)) // 3스트라이크가 나올때까지
    }

    private fun checkStrike(input: String): Boolean {
        val inputArray = changeStringToIntArray(input)
        val strike = countStrike(inputArray)
        val ball = countBall(inputArray)
        printResult(strike, ball)

        if (strike == 3) {
            return true
        } else {
            return false
        }
    }

    private fun countStrike(inputNumber: IntArray): Int {
        var strike = 0
        for (i in inputNumber.indices) {
            if (inputNumber[i] == comNumber[i]) {
                strike++
            }
        }
        return strike
    }

    private fun countBall(inputNumber: IntArray): Int {
        var ball = 0
        for (i in inputNumber.indices) {
            if (comNumber.contains(inputNumber[i])) {
                ball++
            }
        }
        return ball
    }

    // 사용자에게 입력받은 문자열을 정수 배열로 변환
    private fun changeStringToIntArray(inputString: String): IntArray {
        val intArray = IntArray(3)
        val stringArray: Array<String> = inputString.toCharArray().map { it.toString() }.toTypedArray()
        if (stringArray.size != 3) {
            throw IllegalArgumentException("사용자 입력에서 잘못된 길이로 인한 오류 발생")
        }
        for (i in 0 until 3) {
            if ((stringArray[i].toInt() < 0) or (stringArray[i].toInt() > 9)) {
                throw IllegalArgumentException("사용자 입력에서 잘못된 입력으로 인한 오류 발생")
            }
            if (intArray.contains(stringArray[i].toInt())) {
                throw IllegalArgumentException("사용자 입력에서 중복된 입력으로 인한 오류 발생")
            } else {
                intArray[i] = stringArray[i].toInt()
            }
        }
        return intArray
    }

    private fun printResult(strike: Int, ball: Int) {
        val temp = ball - strike
        if (ball == 0) {
            printNothing()
        } else {
            printBall(temp)
            printStrike(strike)
            println("")
        }
        printSuccess(strike)

    }

    private fun printNothing() {
        println("낫싱")
    }

    private fun printStrike(strike: Int) {
        if (strike != 0) {
            print("${strike}스트라이크")
        }
    }

    private fun printBall(ball: Int) {
        if (ball != 0) {
            print("${ball}볼 ")
        }
    }

    private fun printSuccess(strike: Int) {
        if (strike == 3) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        }
    }
}