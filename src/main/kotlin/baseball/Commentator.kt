package baseball

class Commentator {
    fun commentate(message: String) {
        println(message)
    }

    fun commentate(ballCount: BallCount) {
        println(ballCount.getMessage())
    }
}
