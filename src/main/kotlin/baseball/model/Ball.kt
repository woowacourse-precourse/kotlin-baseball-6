package baseball.model

class Ball(num: Int) {
    private val num: Int

    init {
        require(num in 0 until 10) { "$num 가 1자리 수가 아닙니다." }
        this.num = num
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is Ball) return false

        return this.num == other.num
    }

    override fun toString(): String {
        return "Ball($num)"
    }

    override fun hashCode(): Int {
        return num
    }
}