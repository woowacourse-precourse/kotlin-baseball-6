package baseball.model

class BallCount(val Balls:List<Int>,val answer:List<Int>) {
    fun StrikeBallCount(): MutableList<Int>{
        var strike = 0
        var ball = 0
        var strikeBall:MutableList<Int> = mutableListOf()
        for (i in 0..2) {
            val check = Balls[i]
            if (check == answer[i])
                strike++
            else if (check in answer)
                ball++
        }
        strikeBall.add(strike)
        strikeBall.add(ball)
        return strikeBall
    }
}