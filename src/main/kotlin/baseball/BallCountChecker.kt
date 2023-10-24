package baseball

object BallCountChecker {

    fun checkUserInput(userInput: List<Int>, computerNumberList: List<Int>): BallCount {
        var strikeCount = 0
        var ballCount = 0
        userInput.forEachIndexed { _index, _ball ->
            if (_ball == computerNumberList[_index]) {
                strikeCount++
            } else {
                ballCount += checkBallCount(_ball, computerNumberList)
            }
        }
        return BallCount(strikeCount, ballCount)
    }

    private fun checkBallCount(userBall: Int, computerNumberList: List<Int>): Int =
        computerNumberList.count { _computerBall ->
            _computerBall == userBall
        }
}