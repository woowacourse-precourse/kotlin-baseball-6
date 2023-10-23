package baseball.model

class BaseballGame(val computer: Computer = Computer(), val user: User = User()) {

    var state: GameState = GameState.START
    fun getScore(): Score {
        val userNumbers = user.getNumber()
        val ball = getBall(computer.numbers, userNumbers)
        val strike = getStrike(computer.numbers, userNumbers)
        val out = (ball == 0 && strike == 0)
        return Score(ball, strike, out)
    }

    private fun getStrike(computerNumbers: List<Int>, userNumbers: String): Int {
        var strike = 0
        userNumbers.forEachIndexed { index, c ->
            val userNumber = Character.getNumericValue(c)
            if (computerNumbers[index] == userNumber) {
                strike++
            }
        }
        return strike
    }

    private fun getBall(computerNumbers: List<Int>, userNumbers: String): Int {
        var ball = 0
        userNumbers.forEachIndexed { index, c ->
            val userNumber = Character.getNumericValue(c)
            if (computerNumbers.contains(userNumber) && computerNumbers.indexOf(userNumber)!=index) {
                ball++
            }
        }
        return ball
    }
}