package baseball.model

class Playstatus {
    var status : Boolean = true

    fun gameOver() {
        status = false
    }
}