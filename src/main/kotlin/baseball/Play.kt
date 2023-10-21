package baseball

import camp.nextstep.edu.missionutils.Console

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
            else -> println("낫띵")
        }
        this.user = userInput()
        return compare()

    }


    fun compare() {
        val strike = this.calulateState().first
        val ball = this.calulateState().second

        when {
            strike == 3 -> this.gameOver()
            else -> this.newInput(strike, ball)
        }
    }

}

