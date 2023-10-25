package baseball

class GuessResult(secretNumber: String, guessNumber: String) {
    private val ball: Int
    private val strike: Int
    private val text: String

    private fun countBall(secretNumber: String, guessNumber: String): Int {
        var ball = 0
        for (secretIt in 0 until MAX_NUMBER) {
            for (guessIt in 0 until MAX_NUMBER) {
                if (secretIt == guessIt) {
                    continue
                }
                if (secretNumber[secretIt] == guessNumber[guessIt]) {
                    ball++
                }
            }
        }
        return ball
    }

    private fun countStrike(secretNumber: String, guessNumber: String): Int {
        var strike = 0
        for (it in 0 until MAX_NUMBER) {
            if (secretNumber[it] == guessNumber[it]) {
                strike++
            }
        }
        return strike
    }

    override fun toString(): String = text

    fun isCorrect() = strike == MAX_NUMBER

    init {
        this.ball = countBall(secretNumber, guessNumber)
        this.strike = countStrike(secretNumber, guessNumber)
        this.text = when {
            ball == 0 && strike != 0 -> "${strike}스트라이크"
            ball != 0 && strike == 0 -> "${ball}볼"
            ball == 0 -> "낫싱"
            else -> "${ball}볼 ${strike}스트라이크"
        }
    }
}