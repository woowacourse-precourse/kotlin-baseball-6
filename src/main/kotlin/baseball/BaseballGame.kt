package baseball

class BaseballGame {
    private val player = Player()
    private val computer = Computer()

    // 게임 시작
    fun startGame() {
        println("숫자 야구 게임을 시작합니다.")

        while (true) {
            val randomNumber = computer.generateRandomNumbers()
            playRound(randomNumber)

            if (!playAgain()) {
                break
            }
        }
    }
    // 한 라운드를 진행
    private fun playRound(randomNumber: List<Int>) {
        while (true) {
            val userInput = player.getUserInput()

            if (player.isInputValid(userInput)) {
                val result = computer.checkUserInput(userInput, randomNumber)
                println(result)

                if (result == "3스트라이크") {
                    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                    break
                }
            } else {
                throw IllegalArgumentException("잘못된 입력입니다. 애플리케이션을 종료합니다.")
            }
        }
    }

    // 게임을 다시 시작할지 결정
    private fun playAgain(): Boolean {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ")
        val choice = readLine()?.toIntOrNull() ?: 0
        return when (choice) {
            1 -> {
                true
            }
            2 -> false
            else -> {
                throw IllegalArgumentException("잘못된 입력입니다. 애플리케이션을 종료합니다.")
            }
        }
    }
}