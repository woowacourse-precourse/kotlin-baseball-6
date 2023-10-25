package computer

import randombaseballnumbergenerator.RandomBaseballNumberGenerator

class ComputerImpl(
    private val randomBaseballNumberGenerator: RandomBaseballNumberGenerator
) : Computer {
    private var _randomBaseballNumber: String = ""
    override val randomBaseballNumber: String
        get() = _randomBaseballNumber

    override fun setRandomBaseballNumber() {
        _randomBaseballNumber = randomBaseballNumberGenerator.generateRandomBaseballNumber()
    }
}