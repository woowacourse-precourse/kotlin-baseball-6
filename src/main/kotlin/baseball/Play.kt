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

    fun compare() {
        val strike = this.calulateState().first
        val ball = this.calulateState().second

        when {
            strike == 3 -> this.gameOver()
            else -> this.newInput(strike, ball)
        }
    }

}

