package baseball

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

class Play constructor(collect: List<Int>, userAnswer: List<Int>) {
    val computer: List<Int>
    var user: List<Int>
    var result: Boolean

    init {
        this.computer = collect
        this.user = userAnswer
        this.result = false
    }

    fun calulateState(): Pair<Int, Int> {
        var strike: Int = 0
        var ball: Int = 0
        for ((index, compNumber) in computer.withIndex()) {
            when {
                user[index] == compNumber -> strike++
                user.contains(compNumber) -> ball++
            }
        }
        return Pair(strike, ball)
    }
    fun newInput(strike: Int, ball: Int) {
        when {
            ball != 0 && strike != 0 -> println("${ball}볼 ${strike}스트라이크")
            ball != 0 -> println("${ball}볼")
            strike != 0 -> println("${strike}스트라이크")
            else -> println("낫싱")
        }
        try {
            this.user = userInput()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return
        }
        return compare()

    }

    fun gameOver(): Boolean {
        print("3개의 숫자를 모두 맞히셨습니다! 게임종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요")
        val userOpinion = Console.readLine()
        when(userOpinion) {
            "1" -> result = true
            "2" -> {
                result = false
                println("게임 종료")
            }
            else -> this.gameOver()
        }
        return this.result
    }

    fun compare() {
        val strike = this.calulateState().first
        val ball = this.calulateState().second

        when {
            strike == 3 -> {
                println("${strike}스트라이크")
                this.gameOver()
            }
            else -> this.newInput(strike, ball)
        }
    }

}

