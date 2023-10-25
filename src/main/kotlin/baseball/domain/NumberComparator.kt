package baseball.domain

import baseball.constant.ErrorMessage
import baseball.constant.ExtraText

class NumberComparator(private val userInputtedNumber: UserExpect) {

    init {
        val userNumber = userInputtedNumber.convertToInt()
        require(isCorrectRangeNumber(userNumber)) { ErrorMessage.NOT_NUMBER_RANGE.message }
        require(isUniqueNumber(userInputtedNumber.getUserInput())) { ErrorMessage.NOT_DISTINCT_NUMBER.message }
    }

    private val randomNumbers = mutableListOf<Int>()
    private val userNumbers = mutableListOf<Int>()
    private val ballCountResult: BallCountResult = BallCountResult()

    fun compareEachNumbers(randomNumber: RandomNumber): BallCountResult {
        convertUserNumber(userInputtedNumber.getUserInput())
        convertRandomNumber(randomNumber.loadNumber())
        userNumbers.forEachIndexed { index, number ->
            if (randomNumbers.contains(number)) {
                comparePosition(number, index)
            }
        }
        return ballCountResult
    }

    private fun isCorrectRangeNumber(userNumber: Int): Boolean {
        return when (userNumber) {
            in MIN_VALUE..MAX_VALUE -> true
            else -> false
        }
    }

    private fun isUniqueNumber(userNumber: String): Boolean {
        val splitNumber = userNumber.split(ExtraText.BLANK.text)
            .filter { it.isNotBlank() }
            .toMutableList()

        val distinctNumber = splitNumber.distinct()
        return splitNumber.size == distinctNumber.size
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
        val splitNumber = userNumber.split(ExtraText.BLANK.text)
            .filter { it.isNotBlank() }
            .toMutableList()

        if (splitNumber.contains(ExtraText.ZERO.text)) require(false) { ErrorMessage.INPUT_ZERO.message }
        return splitNumber
    }

    companion object {
        private const val MIN_VALUE = 100
        private const val MAX_VALUE = 999
    }
}