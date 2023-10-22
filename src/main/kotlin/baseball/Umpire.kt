package baseball

class Umpire {
    fun judge(playerNumbers: GameNumbers, computerNumbers: GameNumbers): BallCount {
        val strikeCount = playerNumbers.countSameNumberAndPosition(computerNumbers)
        val ballCount = countBalls(playerNumbers, computerNumbers)
        return BallCount(strike = strikeCount, ball = ballCount)
    }

    private fun countBalls(playerNumbers: GameNumbers, computerNumbers: GameNumbers): Int {
        return playerNumbers.countSameNumbers(computerNumbers) - playerNumbers.countSameNumberAndPosition(computerNumbers)
    }
}
