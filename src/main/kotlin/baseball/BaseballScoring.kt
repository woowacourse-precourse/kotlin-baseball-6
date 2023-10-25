package baseball

class BaseballScoring {

    fun calculateScore(answerNumbers: List<Int>, userNumbers: List<Int>): Pair<Int, Int> {
        var strikeCount = 0
        var ballCount = 0
        for (i in answerNumbers.indices) {
            if (userNumbers[i] == answerNumbers[i]) strikeCount++
            else if (answerNumbers.contains(userNumbers[i])) ballCount++
        }
        return Pair(strikeCount, ballCount)
    }

    fun printScore(strikeCount: Int, ballCount: Int) {
        val strikeMessage = if (0 < strikeCount) "${strikeCount}스트라이크" else ""
        val ballMessage = if (0 < ballCount) "${ballCount}볼 " else ""
        val scoreMessage = if (strikeCount == 0 && ballCount == 0) "낫싱" else "$ballMessage$strikeMessage"
        println(scoreMessage)
    }
}