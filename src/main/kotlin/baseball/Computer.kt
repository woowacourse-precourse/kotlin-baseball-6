package baseball

class Computer(private val numberGenerator: NumberGenerator = RandomNumbersGenerator()) {
    private var gameNumbers: GameNumbers = generateRandomGameNumbers()

    fun changeGameNumbers() {
        gameNumbers = generateRandomGameNumbers()
    }

    private fun generateRandomGameNumbers(): GameNumbers {
        val randomNumbers = numberGenerator.generate()
        return GameNumbers(convertFormat(randomNumbers))
    }

    private fun convertFormat(numbers: List<Int>): String {
        return numbers.joinToString("")
    }

    fun getGameNumbers(): GameNumbers {
        return gameNumbers
    }
}
