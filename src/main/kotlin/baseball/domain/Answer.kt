package baseball.domain

class Answer(numbers: List<BallNumber>) : BallNumbers(numbers) {

    // BaseballGame으로부터 가져온 play 메소드. 이름만 compareTo로 변경
    fun compareTo(guess: Guess): BallResult {
        println(strikeCount(guess))
        return BallResult(
            strikeCount(guess),
            ballCount(guess),
        )
    }

    // BaseballGame으로부터 가져온 메소드
    private fun strikeCount(guess: Guess): Int {
        var strikeCount = 0
        for (i in 0..<BALL_COUNT) {
            if (isStrikeAt(i, guess)) {
                strikeCount++
            }
        }
        return strikeCount
    }

    // BaseballGame으로부터 가져온 메소드
    private fun ballCount(guess: Guess): Int {
        var ballCount = 0
        for (i in 0..<BALL_COUNT) {
            if (isBallAt(i, guess)) {
                ballCount++
            }
        }
        return ballCount
    }

    // 내부에서 스스로 데이터를 처리하므로 private로 변경
    private fun isStrikeAt(index: Int, other: Guess) =
        numbers[index] == other.getAt(index)

    // 내부에서 스스로 데이터를 처리하므로 private로 변경
    private fun isBallAt(index: Int, other: Guess) =
        !isStrikeAt(index, other) &&
                numbers.any { it == other.getAt(index) }

}
