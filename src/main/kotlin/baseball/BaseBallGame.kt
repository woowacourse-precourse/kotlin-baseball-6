package baseball

class BaseBallGame {
    private lateinit var computerNumber: List<Int>
    private lateinit var userInput: List<Int>
    private val computer = Computer()
    private val user = User()
    private var result = Result()

    fun controlGame() {
        while (true) {
            playGame()
            if (user.getRestartAnswerInput() == 2)
                break
        }
    }

    private fun playGame() {
        println("숫자 야구 게임을 시작합니다.")
        computerNumber = computer.createRandomNumber()
        while (result.strike != 3) {
            userInput = user.getNumberInput()
            result = judgeResult()
            println(result.toString())
        }
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    private fun judgeResult(): Result {
        val result = Result()
        for (number in userInput) {
            for (answer in computerNumber) {
                if (number == answer) { // 같은 수인 경우
                    // 같은 위치인지 확인
                    if (userInput.indexOf(number) == computerNumber.indexOf(answer))
                        result.strike++
                    else
                        result.ball++
                    break
                }
            }
        }
        return result
    }
}

data class Result(
    var ball: Int = 0,
    var strike: Int = 0,
) {
    override fun toString(): String {
        var resultString = ""
        if (ball > 0)
            resultString += "${ball}볼 "
        if (strike > 0)
            resultString += "${strike}스트라이크"
        return when {
            resultString.isBlank() -> "낫싱"
            else -> resultString
        }
    }
}