package baseball

interface ScoreCalculator {
    fun calculate(computerList: List<Int>, userList: List<Int>): Score
}
