package baseball

class Commentator {
    fun commentate(message: String, newLine: Boolean = true) {
        if (newLine) {
            println(message)
            return
        }
        print(message)
    }

    fun commentate(ballCount: BallCount) {
        println(ballCount.getMessage())
    }
}
