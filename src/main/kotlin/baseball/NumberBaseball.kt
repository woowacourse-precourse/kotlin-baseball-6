package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object NumberBaseball {
    private const val NUM_LENGTH = 3
    private const val RESTART_GAME = "1"
    private const val QUIT_GAME = "2"

    private var comNumList: ArrayList<Int> = arrayListOf()
    private var userNumList: ArrayList<Int> = arrayListOf()

    private var strikeCount = 0
    private var ballCount = 0

    var isPlaying = true
    private fun setDefault() {
        strikeCount = 0
        ballCount = 0
        comNumList.clear()
        userNumList.clear()
    }

    private fun initRandomNumbers(): NumberBaseball {
        while (comNumList.size < NUM_LENGTH) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!comNumList.contains(randomNumber)) comNumList.add(randomNumber)
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
        if (userNumList.size > 0) userNumList.clear()
        val userInput = Console.readLine()
            .removeWhiteSpaces()
        checkValidateInput(userInput)
        userNumList = userInputToNumbers(userInput)
    }

    private fun String.removeWhiteSpaces(): String {
        return this.replace(" ", "")
            .replace("\t", "")
    }

    private fun checkValidateInput(input: String) {
        if (input.length != NUM_LENGTH) throw IllegalArgumentException()
        input.forEach {
            if (it !in '1'..'9') throw IllegalArgumentException()
        }
    }

    private fun userInputToNumbers(input: String): ArrayList<Int> {
        val tempNumList = arrayListOf<Int>()
        input.forEach {
            if (tempNumList.contains(it.digitToInt())) throw IllegalArgumentException()

            tempNumList.add(it.digitToInt())
        }
        return tempNumList
    }

    private fun calculateBallCounts() {
        ballCount = 0
        strikeCount = 0
        userNumList.forEachIndexed { index, value ->
            isStrikeOrBall(index, value)
        }
        printBallCounts(ballCount, strikeCount)
    }

    private fun isStrikeOrBall(index: Int, value: Int) {
        if (comNumList.contains(value)) {
            if (index == comNumList.indexOf(value)) {
                strikeCount++
                return
            }
            ballCount++
            return
        }
    }

    private fun printBallCounts(ball: Int, strike: Int) {
        var strCall = ""

        if (ball == 0 && strike == 0) {
            strCall += "낫싱"
            println(strCall)
            return
        }

        if (ball != 0) {
            strCall += "${ball}볼"
            if (strike != 0) strCall += " "
        }

        if (strike != 0) strCall += "${strike}스트라이크"

        println(strCall)
    }

    fun askQuitOrRestart() {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val temp = Console.readLine().trim()

        if (temp.length != 1) throw IllegalArgumentException()
        if (temp != RESTART_GAME && temp != QUIT_GAME) throw IllegalArgumentException()

        if (temp == QUIT_GAME) isPlaying = false
    }
}