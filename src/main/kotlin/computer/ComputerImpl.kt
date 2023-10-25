package computer

import randombaseballnumbergenerator.RandomBaseballNumberGenerator

class ComputerImpl(
    private val randomBaseballNumberGenerator: RandomBaseballNumberGenerator
) : Computer {
    override val randomBaseballNumber: String
        get() = TODO("Not yet implemented")

    override fun setRandomBaseballNumber() {
        TODO("Not yet implemented")
    }
}