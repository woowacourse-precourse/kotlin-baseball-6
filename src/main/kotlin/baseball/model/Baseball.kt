package baseball.model

class Baseball {
    var strikes : Int = 0
    var balls : Int = 0

    private fun isZero (target : Int) : Boolean {
        return target == 0;
    }

    fun isThreeStrikes () : Boolean {
        return this.strikes == 3
    }

    fun getResultMessage () : String {
        return if(isZero(strikes) && isZero(balls)) {
            "낫싱"
        } else if (isZero(strikes)) {
            "${balls}볼"
        } else if (isZero(balls)) {
            "${strikes}스트라이크"
        } else {
            "${balls}볼 ${strikes}스트라이크 "
        }
    }
}