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
        var message = ""
        if(isZero(strikes) && isZero(balls)) {
            message += "낫싱"
        } else if (isZero(strikes)) {
            message += "${balls}볼"
        } else if (isZero(balls)) {
            message += "${strikes}스트라이크"
        } else {
            message += "${balls}볼 ${strikes}스트라이크 "
        }
        return message
    }
}