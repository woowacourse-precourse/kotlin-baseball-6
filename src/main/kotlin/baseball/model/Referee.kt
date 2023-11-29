package baseball.model

class Referee {
    fun compare(inputNumbers: BaseballNumbers, answer: BaseballNumbers): BallAndStrike {
        var strikeCount = 0
        var ballCount = 0
        for (i in 0 until inputNumbers.numbers.size) {
            val inputNumber = inputNumbers.numbers[i]
            val answerNumber = answer.numbers[i]

            if (inputNumber == answerNumber) {
                strikeCount++
            } else if (answer.numbers.any { it == inputNumber }) {
                ballCount++
            }
        }

        return BallAndStrike(strikeCount, ballCount)
    }

}