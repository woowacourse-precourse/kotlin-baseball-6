package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object NumberBaseball {
    private const val NUM_LENGTH = 3

    private var comNumList: ArrayList<Int> = arrayListOf()
    private var userNumList: ArrayList<Int> = arrayListOf()

    private var strikeCount = 0
    private var ballCount = 0

    var isPlaying = true

    private fun initRandomNumbers(): NumberBaseball {
        while (comNumList.size < NUM_LENGTH) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!comNumList.contains(randomNumber)) comNumList.add(randomNumber)
        }
        return this
    }

    private fun setDefault() {
        strikeCount = 0
        ballCount = 0
        comNumList.clear()
        userNumList.clear()

    }

    fun playBaseball(): NumberBaseball {
        setDefault()
        initRandomNumbers()
        while (strikeCount < NUM_LENGTH) {
            getUserInput()
            calculateBallCounts()
        }
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        return this
    }

    private fun getUserInput() {
        print("숫자를 입력해 주세요 : ")
        if (userNumList.size > 0) userNumList.clear()
        val userInput = Console.readLine()
        checkValidateInput(userInput)
        userNumList = userInputToNumbers(userInput)
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
        var strCall: String = ""

        if (ball == 0 && strike == 0) {
            strCall += "낫싱"
            println(strCall)

            return
        }

        when (ball) {
            1 -> strCall += "1볼 "
            2 -> strCall += "2볼 "
            3 -> strCall += "3볼 "
        }

        when (strike) {
            1 -> strCall += "1스트라이크"
            2 -> strCall += "2스트라이크"
            3 -> strCall += "3스트라이크"
        }
        println(strCall)
    }

    fun askQuitOrRestart() {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val temp = Console.readLine()

        if (temp.length != 1) throw IllegalArgumentException()
        if (temp != "1" && temp != "2") throw IllegalArgumentException()
        if (temp == "1") setDefault()
        if (temp == "2") isPlaying = false
    }
}