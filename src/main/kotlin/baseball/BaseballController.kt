package baseball

class BaseballController {
    private var strike: Int = 0
    private var ball: Int = 0

    fun startGame() {
        var targetNumber = BaseballGame.createNumber()

        BaseballView.displayMessage(GAME_START)

        while (true) {
            val input = BaseballView.readInput(INPUT_NUMBER)

            if (input.length != 3) {
                validateInput()
            }

            val inputNumbers = input.map { it.toString().toInt() }
            calculateCount(inputNumbers, targetNumber)

            BaseballView.displayMessage(getCountMessage())

            if (strike == 3) {
                BaseballView.displayMessage(GAME_OVER)
                BaseballView.displayMessage(RESTART_OR_FINISH)
                restartOrFinish = BaseballView.readInput(INPUT_NUMBER).toInt()
                when (restartOrFinish) {
                    1 -> {
                        targetNumber = BaseballGame.createNumber()
                    }
                    2 -> {
                        return
                    }
                    else -> {
                        validateInput()
                    }
                }
            }

            initCount()
        }
    }

    private fun validateInput() {
        throw IllegalArgumentException()
    }

    private fun calculateCount(inputNumbers: List<Int>, numbers: List<Int>) {
        for (index in inputNumbers.indices) {
            if (numbers[index] == inputNumbers[index]) {
                strike++
            }
        }

        for (num in inputNumbers) {
            if (num in numbers && (inputNumbers.indexOf(num) != numbers.indexOf(num))) {
                ball++
            }
        }
    }

    private fun getCountMessage(): String {
        return when {
            strike == 0 && ball == 0 -> NOTHING
            else -> "${ball}볼 ${strike}스트라이크"
        }
    }

    private fun initCount() {
        strike = 0
        ball = 0
    }
}