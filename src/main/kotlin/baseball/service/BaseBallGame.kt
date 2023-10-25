package baseball.service

import baseball.constant.ChoiceState
import baseball.domain.BallCountResult
import baseball.domain.BaseBallGameRestarter
import baseball.domain.NumberComparator
import baseball.domain.UserExpect
import baseball.repository.RandomNumberRepository
import baseball.util.RandomNumberGenerator

class BaseBallGame {

    private val randomNumberRepository = RandomNumberRepository()

    init {
        initRandomNumber()
    }

    fun playGame(userExpect: UserExpect): BallCountResult {
        val numberComparator = NumberComparator(userExpect)
        return numberComparator.compareEachNumbers(randomNumberRepository.loadRandomNumber())
    }

    fun restartChoice(userChoice: Int): ChoiceState {
        val gameRestarter = BaseBallGameRestarter(userChoice)
        return gameRestarter.checkRestartChoice()
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