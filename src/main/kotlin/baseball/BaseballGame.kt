package baseball

import baseball.model.Baseball

class BaseballGame {
    fun compareNumbers(target: MutableList<Int>, compare: List<Int>): Baseball {
        val baseball = Baseball()
        for (i in target.indices) {
            if (target[i] == compare[i]) {
                baseball.strikes++
            } else if (target.contains(compare[i])) {
                baseball.balls++
            }
        }
        return baseball
    }
}