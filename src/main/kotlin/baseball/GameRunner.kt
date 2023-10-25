package baseball

class GameRunner {
    fun run() {
        println("숫자 야구 게임을 시작합니다.")
        do {
            val computerNumberGenerator = ComputerNumberGenerator()
            val userInput = UserInput()
            val scoreCalculator = BaseballScoreCalculator()

            val game = Game(computerNumberGenerator, userInput, scoreCalculator)
            game.start()
        } while (game.isRestart())
    }
}
