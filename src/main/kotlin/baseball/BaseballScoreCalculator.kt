package baseball

class BaseballScoreCalculator : ScoreCalculator {
    override fun calculate(computerList: List<Int>, userList: List<Int>): Score {
        var strikeCount = 0
        var ballCount = 0

        computerList.forEachIndexed { index, number ->
            if (userList[index] == number) strikeCount++
            else if (userList[index] in computerList) ballCount++
        }

        return Score(strikeCount, ballCount)
    }
}
