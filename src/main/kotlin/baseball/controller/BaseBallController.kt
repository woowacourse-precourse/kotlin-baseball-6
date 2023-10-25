package baseball.controller
import baseball.model.Computer
import baseball.model.User
import baseball.view.View

class BaseBallController {
    fun play() {
        val newUser = User()
        val newView = View()
        try {
            var restart : String = "1"
            newView.gameStart()
            while (restart == "1") {
                val computer = Computer.pickNumbers()
                var breakIdx : Boolean = false

                while (!breakIdx) {
                    newView.requireInput()
                    val input = readLine()
                    val user = newUser.guess(input)
                    val baseball = Computer.baseball(user, computer)
                    val strikes = baseball.first
                    val balls = baseball.second
                    breakIdx = newView.check(strikes, balls)
                }
                restart = newView.restart()
            }
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException()
        }
    }
}