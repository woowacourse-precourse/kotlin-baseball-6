package baseball.service

import baseball.constant.ChoiceState
import baseball.domain.BallCountResult
import baseball.domain.BaseBallGameRestarter
import baseball.domain.NumberComparator
import baseball.repository.RandomNumberRepository
import baseball.util.RandomNumberGenerator

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
            i * DIGIT_UNIT + j
        })
    }

    companion object {
        private const val DIGIT_UNIT = 10
    }
}