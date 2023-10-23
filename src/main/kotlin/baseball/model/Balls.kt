package baseball.model

class Balls(num: Int) {
    companion object {
        const val MAX_BALLS: Int = 3
    }

    private val balls: List<Ball>


    init {
        val numList = num.toString().map { it.toString().toInt() }
        checkNumList(numList = numList)
        this.balls = numList.map { Ball(num = it) }
    }

    private fun checkNumList(numList: List<Int>) {
        require(numList.size == MAX_BALLS) { "Ball 갯수가 $MAX_BALLS 이 아닌 ${numList.size} 입니다." }
        require(numList.size == numList.distinct().size) { "중복된 값이 존재하면 안됩니다." }
    }

    override fun toString(): String {
        return "Balls: ${balls.toString()}"
    }
}