package baseball.gamemachine


class StrikeBallChecker {

    fun checkAnswer(
        computerNum: List<Int>,
        myNum: List<Int>
    ): List<Int> {
        val strike = countStrike(computerNum, myNum)
        val ball = countBall(computerNum, myNum, strike)

        return listOf(ball, strike)
    }

    private fun countStrike(
        computerNum: List<Int>,
        myNum: List<Int>
    ): Int {
        val numSize = computerNum.size
        var count = 0

        for (i in 0 until numSize) {
            if (computerNum[i] == myNum[i]) {
                count++
            }
        }
        return count
    }

    private fun countBall(
        computerNum: List<Int>,
        myNum: List<Int>,
        strike: Int
    ): Int {
        val numSize = computerNum.size
        var count = 0

        for (i in 0 until numSize) {
            if (computerNum.contains(myNum[i])) {
                count++
            }
        }
        count -= strike
        return count
    }
}