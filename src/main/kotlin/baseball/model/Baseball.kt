package baseball.model

class Baseball {
    var strikes : Int = 0
    var balls : Int = 0

    fun isZero (target : Int) : Boolean {
        return target == 0;
    }

    fun isThreeStrikes () : Boolean {
        return this.strikes == 3
    }

    fun getResultMessage () : String {
        if(isZero(strikes) && isZero(balls)) {
            return "낫싱"
        } else if (isZero(strikes)) {
            return "${balls}볼"
        } else if (isZero(balls)) {
            return "${strikes}스트라이크"
        } else {
            return "${balls}볼 ${strikes}스트라이크 "
        }
    }
}