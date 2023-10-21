package baseball.model

class BaseballGame(val computer: Computer = Computer(), val user: User = User()) {

    var state: GameState = GameState.START

    fun compareNumbers(): Score {
        val computerNumber = computer.getNumber()
        var strike = 0
        var ball = 0
        user.getNumber().forEachIndexed { index, c ->
            val userNum = Character.getNumericValue(c)
            if (computerNumber.contains(userNum) && computerNumber[index] == userNum)
                strike++
            else if (computerNumber.contains(userNum))
                ball++
        }
        if (strike == 0 && ball == 0)
            return Score(0, 0, true)

        return Score(ball, strike, false)
    }
}