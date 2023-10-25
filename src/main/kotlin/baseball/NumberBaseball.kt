package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object NumberBaseball {
    private const val NUM_LENGTH = 3
    private const val RESTART_GAME = "1"
    private const val QUIT_GAME = "2"

    private var comNumbers: ArrayList<Int> = arrayListOf()
    private var userNumbers: ArrayList<Int> = arrayListOf()

    private var strikeCount = 0
    private var ballCount = 0

    var isPlaying = true
    private fun setDefault() {
        strikeCount = 0
        ballCount = 0
        comNumbers.clear()
        userNumbers.clear()
    }

    private fun initRandomNumbers(): NumberBaseball {
        while (comNumbers.size < NUM_LENGTH) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!comNumbers.contains(randomNumber)) comNumbers.add(randomNumber)
        }
        return this
    }

    fun playNumberBaseball(): NumberBaseball {
        setDefault()
        initRandomNumbers()
        while (strikeCount < NUM_LENGTH) {
            getUserInput()
            calculateBallCounts()
        }
        println("${NUM_LENGTH}개의 숫자를 모두 맞히셨습니다! 게임 종료")
        return this
    }

    private fun getUserInput() {
        print("숫자를 입력해 주세요 : ")
        if (userNumbers.size > 0) userNumbers.clear()
        val userInput = Console.readLine().removeWhiteSpaces()
        checkValidateInput(userInput)
        userNumbers = userInputToNumbers(userInput)
    }

    // 사용자 입력에서 공백 문자를 제거하기 위한 확장 함수
    private fun String.removeWhiteSpaces(): String {
        return this.replace(" ", "").replace("\t", "")
    }

    private fun checkValidateInput(input: String) {
        require(input.length == NUM_LENGTH) { "세 자리 수를 입력하세요." }
        input.forEach {
            require(it in '1'..'9') { "올바른 입력이 아닙니다." }
        }
    }

    // 사용자의 입력을 정수로 변환해 ArrayList<Int>에 담고 ArrayList<Int>를 반환합니다.
    private fun userInputToNumbers(input: String): ArrayList<Int> {
        val tempNumbers = arrayListOf<Int>()
        input.forEach {
            require(!tempNumbers.contains(it.digitToInt())) { "중복된 숫자는 입력하실 수 없습니다." }

            tempNumbers.add(it.digitToInt())
        }
        return tempNumbers
    }

    private fun calculateBallCounts() {
        ballCount = 0
        strikeCount = 0
        userNumbers.forEachIndexed { index, value ->
            isStrikeOrBall(index, value)
        }
        printBallCounts(ballCount, strikeCount)
    }

    private fun isStrikeOrBall(index: Int, value: Int) {
        if (comNumbers.contains(value)) {
            if (index == comNumbers.indexOf(value)) {
                strikeCount++
                return
            }
            ballCount++
            return
        }
    }

    private fun printBallCounts(ball: Int, strike: Int) {
        var call = ""

        if (ball == 0 && strike == 0) {
            call += "낫싱"
            println(call)
            return
        }

        if (ball != 0) {
            call += "${ball}볼"
            if (strike != 0) call += " "
        }

        if (strike != 0) call += "${strike}스트라이크"

        println(call)
    }

    fun askQuitOrRestart() {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val tempStr = Console.readLine().trim()

        require(tempStr.length == 1) { "올바른 입력이 아닙니다." }
        require(tempStr == RESTART_GAME || tempStr == QUIT_GAME) { "올바른 입력이 아닙니다." }

        if (tempStr == QUIT_GAME) isPlaying = false
    }
}