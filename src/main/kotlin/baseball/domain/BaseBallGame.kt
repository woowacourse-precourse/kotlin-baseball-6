package baseball.domain

import baseball.repository.RandomNumberRepository

class BaseBallGame {

    private val randomNumberRepository = RandomNumberRepository()

    init {
        initRandomNumber()
    }

    fun playGame(userNumber: String): BallCountResult {
        val numberComparator = NumberComparator()
        return numberComparator.compareEachNumbers(userNumber, randomNumberRepository.loadRandomNumber())
    }

    fun restartChoice(userChoice: String): ChoiceState {
        val gameRestarter = BaseBallGameRestarter()
        return gameRestarter.checkRestartChoice(userChoice)
    }

    fun restartGame() {
        initRandomNumber()
    }

    private fun initRandomNumber() {
        randomNumberRepository.saveRandomNumber(RandomNumberGenerator().generate().reduce { i, j ->
            i * 10 + j
        })
    }


}