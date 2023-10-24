package baseball.domain

class NumberComparator {

    private lateinit var randomNumbers: MutableList<Int>
    private lateinit var userNumbers: MutableList<Int>
    private val ballCountResult: BallCountResult = BallCountResult()

    fun compareEachNumbers(userInputtedNumber: String): BallCountResult {
        convertUserNumber(userInputtedNumber)
        userNumbers.forEachIndexed { index, number ->
            if (randomNumbers.contains(number)) {
                comparePosition(number, index)
            }
        }
        return ballCountResult
    }

    private fun comparePosition(number: Int, index: Int) {
        if (randomNumbers.indexOf(number) == index) {
            ballCountResult.addStrike()
            return
        }
        ballCountResult.addBall()
    }

    private fun convertUserNumber(userNumber: String) {
        val splitNumber = userNumber.split("").toMutableList()
        splitNumber.remove("")
        splitNumber.remove("")
        if (splitNumber.contains("0")) require(true) { "0 입력 오류!" }

        splitNumber.forEach {
            userNumbers.add(it.toInt())
        }
    }
}