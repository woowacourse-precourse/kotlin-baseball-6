package baseball

class BaseBallsValidator {
    fun validate(balls: List<Int>) {
        if (isThreeBall(balls) && isBallNumberInRange(balls) && isBallNotDuplicated(balls)) return
        throw IllegalArgumentException()
    }

    private fun isThreeBall(balls: List<Int>): Boolean {
        return balls.size == 3
    }

    private fun isBallNumberInRange(balls: List<Int>): Boolean {
        return balls.all {
            it in 1..9
        }
    }

    private fun isBallNotDuplicated(balls: List<Int>): Boolean {
        return balls[0] != balls[1] && balls[1] != balls[2]
    }
}