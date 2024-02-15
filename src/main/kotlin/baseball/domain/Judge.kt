package baseball.domain

class Judge {

    fun judgeBall(numberSize: Int, computer: MutableList<Int>, inputNumbers: String): Int {
        var ballCount = 0
        for (i in 0 until numberSize) {
            if (computer.contains(inputNumbers[i].toString().toInt())) {
                if (computer[i] != inputNumbers[i].toString().toInt()) {
                    ballCount++
                }
            }
        }
        return ballCount
    }

    fun judgeStrike(numberSize: Int, computer: MutableList<Int>, inputNumbers: String): Int {
        var strikeCount = 0
        for (i in 0 until numberSize) {
            if (computer[i] == inputNumbers[i].toString().toInt()) {
                strikeCount++
            }
        }
        return strikeCount
    }

    fun isGameOver(strikeCount: Int, numberSize: Int): Boolean {
        return strikeCount == numberSize
    }

}