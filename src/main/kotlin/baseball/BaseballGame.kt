package baseball

import baseball.model.Baseball

class BaseballGame {
    fun compareNumbers(target: List<Int>, compare: List<Int>): Baseball {
        var rslt = Baseball()
        for (i in target.indices) {
            if (target[i] == compare[i]) {
                rslt.strikes++
            } else if (target.contains(compare[i])) {
                rslt.balls++
            }
        }
        return rslt
    }
}