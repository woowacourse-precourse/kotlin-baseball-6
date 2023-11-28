package baseball.model

class Referee {

    fun compare(inputNumbers: BaseballNumbers, answer: BaseballNumbers): BallAndStrike {
        var strikeCount = 0
        var ballCount = 0
        for (i in 0 until inputNumbers.numbers.size) {
            if (inputNumbers.numbers[i] == answer.numbers[i]) {
                strikeCount++
                continue
            }
            if (answer.numbers.contains(BaseballNumber(inputNumbers.numbers[i].number))) {
                ballCount++
            }
        }

        return BallAndStrike(strikeCount, ballCount)
    }


}