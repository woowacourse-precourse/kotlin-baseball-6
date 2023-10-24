package baseball.domain

class NumberComparator {

    private val randomNumbers = mutableListOf<Int>()
    private val userNumbers = mutableListOf<Int>()
    private val ballCountResult: BallCountResult = BallCountResult()

    fun compareEachNumbers(userInputtedNumber: String, randomNumber: RandomNumber): BallCountResult {
        convertUserNumber(userInputtedNumber)
        convertRandomNumber(randomNumber.loadNumber())
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
        val splitNumber = convertNumber(userNumber)

        splitNumber.forEach {
            userNumbers.add(it.toInt())
        }
    }

    private fun convertRandomNumber(randomNumber: Int) {
        val splitNumber = convertNumber(randomNumber.toString())
        splitNumber.forEach {
            randomNumbers.add(it.toInt())
        }
    }

    private fun convertNumber(userNumber: String): MutableList<String> {
        val splitNumber = userNumber.split("").toMutableList()
        splitNumber.remove("")
        splitNumber.remove("")
        if (splitNumber.contains("0")) require(true) { "0 입력 오류!" }
        return splitNumber
    }
}