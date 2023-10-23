package baseball

object Hint {
    fun compareNumber(computer: List<Int>, player: List<Int>) {
        isStrike(computer, player)
        isBall(computer, player)
    }

    private fun isStrike(computer: List<Int>, player: List<Int>) {
        for (i in 0 until 3) {
            if (computer[i] == player[i]) {
                GameCount.plusStrikeCount()
            }
        }
    }

    private fun isBall(computer: List<Int>, player: List<Int>) {
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                if (i != j && computer[i] == player[j]) {
                    GameCount.plusBallCount()
                }
            }
        }
    }

}