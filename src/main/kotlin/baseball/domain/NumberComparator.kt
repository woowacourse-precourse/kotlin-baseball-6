package baseball.domain

import baseball.constant.ErrorMessage
import baseball.constant.ExtraText

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
        val splitNumber = userNumber.split(ExtraText.BLANK.text).toMutableList()
        splitNumber.remove(ExtraText.BLANK.text)
        splitNumber.remove(ExtraText.BLANK.text)
        if (splitNumber.contains(ExtraText.ZERO.text)) require(true) { ErrorMessage.INPUT_ZERO.message }
        return splitNumber
    }
}