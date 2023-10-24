package baseball.view

object OutputView {
    fun showResult(balls: Int, strikes: Int) {
        val result = StringBuilder()

        if (balls == 0 && strikes == 0) {
            result.append("낫싱")
        } else {
            if (balls > 0) result.append("${balls}볼 ")
            if (strikes > 0) result.append("${strikes}스트라이크")
        }

        println(result.trim())
    }
}
