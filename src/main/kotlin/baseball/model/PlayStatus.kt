package baseball.model

class PlayStatus {
    var status : Boolean = true

    fun gameOver() {
        status = false
    }
}