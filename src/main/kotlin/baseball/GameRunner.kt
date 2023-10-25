package baseball

import baseball.GameMessage.GAME_START_MESSAGE

class GameRunner {
    fun run() {
        println(GAME_START_MESSAGE)
        do {
            val computerNumberGenerator = ComputerNumberGenerator()
            val userInput = UserInput()
            val scoreCalculator = BaseballScoreCalculator()

            val game = Game(computerNumberGenerator, userInput, scoreCalculator)
            game.start()
        } while (game.isRestart())
    }
}
