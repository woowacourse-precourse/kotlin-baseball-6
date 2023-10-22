package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object NumberBaseball {
    private const val NUM_LENGTH = 3

    private val comNumList: ArrayList<Int> = arrayListOf()
    private var userNumList: ArrayList<Int> = arrayListOf()

    private var strikeCount = 0
    private var ballCount = 0

    fun initRandomNumbers(): NumberBaseball {
        while (comNumList.size < NUM_LENGTH) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!comNumList.contains(randomNumber)) comNumList.add(randomNumber)
        }
        println(comNumList)
        println("숫자 야구 게임을 시작합니다.")

        return this
    }

    fun playBaseball(): NumberBaseball {
        while (strikeCount < NUM_LENGTH) {
            getUserInput()
            calculateBallCounts()
        }
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")

        return this
    }

    private fun getUserInput() {
        print("숫자를 입력해 주세요 : ")
        userNumList = Console.readLine()
            .convertInputToNumbers()
    }

    // 사용자의 입력을 Int로 바꿔 ArrayList에 담는다.
    private fun String.convertInputToNumbers(): ArrayList<Int> {
        val tempList = arrayListOf<Int>()
        this.forEach {
            if ((it in '1'..'9') && !tempList.contains(it.digitToInt())) { // 중복된 숫자를 허용하지 않는다.
                tempList.add(it.digitToInt())
                return@forEach
            }
            if (it != ' ' && it != '\t') throw IllegalArgumentException() // 공백과 탭 문자는 무시한다.
        }
        if (tempList.size != NUM_LENGTH) throw IllegalArgumentException() // 리스트에 담긴 숫자가 NUM_LENGTH가 아니면 예외처리한다.

        return tempList
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
}