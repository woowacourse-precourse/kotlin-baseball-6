package baseball.domain

class Judge {
    fun judgeBall(numberSize: Int, computerNumbers: MutableList<Int>, userNumbers: String): Int {
        var ballCount = 0
        for (i in 0 until numberSize) {
            if (computerNumbers.contains(userNumbers[i].toString().toInt())) {
                if (computerNumbers[i] != userNumbers[i].toString().toInt()) {
                    ballCount++
                }
            }
        }
        return ballCount
    }

    fun judgeStrike(numberSize: Int, computerNumbers: MutableList<Int>, userNumbers: String): Int {
        var strikeCount = 0
        for (i in 0 until numberSize) {
            if (computerNumbers[i] == userNumbers[i].toString().toInt()) {
                strikeCount++
            }
        }
        return strikeCount
    }

    fun isGameOver(strikeCount: Int, numberSize: Int): Boolean {
        return strikeCount == numberSize
    }
}