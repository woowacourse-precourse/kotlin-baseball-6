package baseball

data class BaseballScore(val strike: Int = 0, val ball: Int = 0)

interface BaseballComparator {
    fun compare(computer: String, user: String): BaseballScore
}

class LinearComparator : BaseballComparator {
    override fun compare(computer: String, user: String): BaseballScore {
        var strike = 0
        var ball = 0

        for (i in user.indices) {
            for (j in computer.indices) {
                if (user[i] == computer[j]) {
                    if (i == j) {
                        strike += 1
                    } else {
                        ball += 1
                    }
                }
            }
        }

        return BaseballScore(strike, ball)
    }
}

class RotationComparator : BaseballComparator {
    override fun compare(computer: String, user: String): BaseballScore =
        (0..user.lastIndex).map { rotate(user, it) }.foldIndexed(BaseballScore()) { index, acc, item ->
            val score = item.zip(computer).count { it.first == it.second }
            if (index == 0) {
                acc.copy(strike = acc.strike + score)
            } else {
                acc.copy(ball = acc.ball + score)
            }
        }

    private fun rotate(str: String, degree: Int): String {
        val sb = StringBuilder()
        val rotateNum = degree % str.length

        val back = str.substring(0..str.lastIndex - rotateNum)
        val front = str.substring(str.length - rotateNum until str.length)
        sb.append(front).append(back)

        return sb.toString()
    }
}
