package baseball.model

class Balls(numList: List<Int>) {
    companion object {
        const val MAX_BALLS: Int = 3
    }

    private val balls: List<Ball>


    init {
        require(numList.size == MAX_BALLS) { "Ball 갯수가 $MAX_BALLS 이 아닌 ${numList.size} 입니다." }
        require(numList.size == numList.distinct().size) { "중복된 값이 존재하면 안됩니다." }
        this.balls = numList.map { Ball(num = it) }
    }

    fun contains(ball: Ball): Boolean {
        return this.balls.contains(ball)
    }

    operator fun get(idx: Int): Ball {
        return this.balls[idx]

    }

    override fun toString(): String {
        return "Balls: $balls"
    }
}