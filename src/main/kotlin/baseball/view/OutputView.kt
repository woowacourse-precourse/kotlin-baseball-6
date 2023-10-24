package baseball.view

import baseball.domain.Constants

object OutputView {
    fun showHint(balls: Int, strikes: Int) {
        val result = StringBuilder()

        if (balls == 0 && strikes == 0) {
            result.append(Constants.NOTHING)
        } else {
            if (balls > 0) result.append("${balls}${Constants.BALL} ")
            if (strikes > 0) result.append("${strikes}${Constants.STRIKE}")
        }

        println(result.trim())
    }
}
