package baseball

object Hint {
    fun compareNumber(computer: List<Int>, player: List<Int>): Boolean {

        val nothingFlag = isNothing(computer, player)
        return when (nothingFlag) {
            true -> {
                false
            }

            else -> {
                isStrike(computer, player)
                isBall(computer, player)
                true
            }
        }
    }

    private fun isNothing(computer: List<Int>, player: List<Int>): Boolean {
        for(i in 0 until 3) {
            if (player.contains(computer[i])) {
                return false
            }
            // 포함이 전혀 안된 상태(낫싱)
        }
        return true
    }

    private fun isStrike(computer: List<Int>, player: List<Int>) {
        for(i in 0 until 3) {
            if (computer[i] == player[i]) {
                GameCount.plusStrikeCount()
            }
        }
    }

    private fun isBall(computer: List<Int>, player: List<Int>) {
        for (i in 0 until 3) {
            for(j in 0 until 3) {
                if (i != j && computer[i] == player[j]) {
                    GameCount.plusBallCount()
                }
            }
        }
    }

}