package baseballgame

import constant.Constant
import constant.StringError
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.IllegalArgumentException

class Game {
    private val comNumber = mutableListOf<Int>()// 컴퓨터 난수 저장

    init {
        while (comNumber.size < Constant.CORRECT_USER_SIZE) {
            val randomNumber = Randoms.pickNumberInRange(Constant.START_NUMBER, Constant.END_NUMBER)
            if (!comNumber.contains(randomNumber)) {
                comNumber.add(randomNumber)
            }
        }
        println(comNumber) // 중간 확인용
    }

    // 프로그램 실행
    companion object {
        fun run() {
            do {
                val game = Game()
                game.userEnter()
            } while (game.restart())
        }
    }

    // 재시작 여부 확인
    private fun restart(): Boolean {
        print(Constant.RESTART_STRING)
        val select = Console.readLine()
        return when (select) {
            Constant.RESTART_INPUT -> {
                true
            }

            Constant.TERMINATE_INPUT -> {
                false
            }

            else -> {
                throw IllegalArgumentException(StringError.RESTART_ERROR)
            }
        }
    }

    // 사용자로부터 3자리수 입력 받기
    private fun userEnter() {
        do {
            print(Constant.INPUT_STRING)
            val userNumber = Console.readLine()
        } while (!checkStrike(userNumber)) // 3스트라이크가 나올때까지
    }

    // 스트라이크 개수가 3개인지 확인
    private fun checkStrike(input: String): Boolean {
        val inputArray = changeStringToIntArray(input)
        val strike = countStrike(inputArray)
        val ball = countBall(inputArray)
        printResult(strike, ball)

        if (strike == Constant.SUCCESS) {
            return true
        } else {
            return false
        }
    }

    // 사용자에게 입력받은 문자열을 정수 배열로 변환
    private fun changeStringToIntArray(inputString: String): IntArray {
        val intArray = IntArray(Constant.CORRECT_USER_SIZE)
        val stringArray: Array<String> = inputString.toCharArray().map { it.toString() }.toTypedArray()
        checkInputLength(stringArray)
        checkInputValue(stringArray, intArray)
        return intArray
    }

    // Strike 개수 카운트
    private fun countStrike(inputNumber: IntArray): Int {
        var strike = 0
        for (i in inputNumber.indices) {
            if (inputNumber[i] == comNumber[i]) {
                strike++
            }
        }
        return strike
    }

    // Ball 개수 카운트
    private fun countBall(inputNumber: IntArray): Int {
        var ball = 0
        for (i in inputNumber.indices) {
            if (comNumber.contains(inputNumber[i])) {
                ball++
            }
        }
        return ball
    }

    // Input 길이 확인
    private fun checkInputLength(stringArray: Array<String>) {
        if (stringArray.size != Constant.CORRECT_USER_SIZE) {
            throw IllegalArgumentException(StringError.INPUT_LENGTH_ERROR)
        }
    }

    // Input Value 확인
    private fun checkInputValue(stringArray: Array<String>, intArray: IntArray) {
        for (i in 0 until Constant.CORRECT_USER_SIZE) {
            if ((stringArray[i].toInt() < 0) or (stringArray[i].toInt() > 9)) {
                throw IllegalArgumentException(StringError.INPUT_VALUE_ERROR)
            }
            if (intArray.contains(stringArray[i].toInt())) {
                throw IllegalArgumentException(StringError.INPUT_OVERLAP_ERROR)
            } else {
                intArray[i] = stringArray[i].toInt()
            }
        }
    }

    // 결과 출력
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
        println(Constant.NOTHING)
    }

    private fun printStrike(strike: Int) {
        if (strike != 0) {
            print("${strike}${Constant.STRIKE}")
        }
    }

    private fun printBall(ball: Int) {
        if (ball != 0) {
            print("${ball}${Constant.BALL}")
        }
    }

    private fun printSuccess(strike: Int) {
        if (strike == Constant.SUCCESS) {
            println(Constant.SUCCESS_STRING)
        }
    }
}